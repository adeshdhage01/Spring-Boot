package com.example.weatherapp.controller;

import com.example.weatherapp.dto.WeatherResponse;
import com.example.weatherapp.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {
    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String home() {
        return "weather";
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city, Model model) {
        try {
            logger.info("Fetching weather for city: {}", city);
            WeatherResponse weather = weatherService.getWeather(city);
            
            if (weather == null) {
                logger.warn("Weather response is null for city: {}", city);
                model.addAttribute("error", "No weather data received from service.");
                return "weather";
            }
            
            logger.debug("Weather data received: {}", weather);
            model.addAttribute("weather", weather);
            
        } catch (Exception e) {
            logger.error("Error fetching weather for city: " + city, e);
            model.addAttribute("error", "Error fetching weather data: " + e.getMessage());
        }
        return "weather";
    }
}