package com.example.weatherapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private String name;
    private Main main;
    private List<Weather> weather;
    private Wind wind;
    private Sys sys;

    // Manual getters if Lombok fails
    public String getName() { return name; }
    public Main getMain() { return main; }
    public List<Weather> getWeather() { return weather; }
    public Wind getWind() { return wind; }
    public Sys getSys() { return sys; }

    @Data
    public static class Main {
        private double temp;
        @JsonProperty("feels_like")
        private double feelsLike;
        @JsonProperty("temp_min")
        private double tempMin;
        @JsonProperty("temp_max")
        private double tempMax;
        private int humidity;

        // Manual getters
        public double getTemp() { return temp; }
        public double getFeelsLike() { return feelsLike; }
        public double getTempMin() { return tempMin; }
        public double getTempMax() { return tempMax; }
        public int getHumidity() { return humidity; }
    }

    @Data
    public static class Weather {
        private String main;
        private String description;
        private String icon;

        // Manual getters
        public String getMain() { return main; }
        public String getDescription() { return description; }
        public String getIcon() { return icon; }
    }

    @Data
    public static class Wind {
        private double speed;
        private int deg;

        // Manual getters
        public double getSpeed() { return speed; }
        public int getDeg() { return deg; }
    }

    @Data
    public static class Sys {
        private String country;
        private long sunrise;
        private long sunset;

        // Manual getters
        public String getCountry() { return country; }
        public long getSunrise() { return sunrise; }
        public long getSunset() { return sunset; }
    }
}