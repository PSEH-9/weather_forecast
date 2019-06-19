package com.publicissapient.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MainDetails {
    private double temp;
    @JsonProperty("temp_min")
    private double tempMinimum;
}
