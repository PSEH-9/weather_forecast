package com.publicissapient.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TemperatureDetails {
    private long dt;
    private MainDetails main;
    private WeatherDetails weather;
    private Clouds clouds;
    private Wind wind;
    @JsonProperty("dt_txt")
    private String dateString;
}
