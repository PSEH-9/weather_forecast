package com.publicissapient.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class City {
    private long id;
    @JsonProperty("name")
    private String cityName;
    @JsonProperty("country")
    private String countryCode;
    @JsonProperty("list")
    private List<TemperatureDetails> temperatureDetailsList;
}
