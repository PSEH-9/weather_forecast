package com.publicissapient.weatherforecast.model;

import lombok.Data;

@Data
public class WeatherResponse {
    private MainDetails main;
    private String alertText;
    private String name;
}
