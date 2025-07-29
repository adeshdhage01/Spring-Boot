package com.example.weatherapp.service;

import com.example.weatherapp.dto.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {
    private final RestTemplate restTemplate;
    private final String apiKey;
    private final String baseUrl;
    private final String units;

    public WeatherService(RestTemplate restTemplate,
                        @Value("${app.weather.base-url}") String baseUrl,
                        @Value("${app.weather.api-key}") String apiKey,
                        @Value("${app.weather.units}") String units) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.units = units;
    }

    @Cacheable(value = "weather", key = "#city")
    public WeatherResponse getWeather(String city) {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .queryParam("units", units)
                .toUriString();

        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}