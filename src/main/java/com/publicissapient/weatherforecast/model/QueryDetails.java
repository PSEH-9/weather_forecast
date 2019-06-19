package com.publicissapient.weatherforecast.model;

import lombok.Data;

@Data
public class QueryDetails {
    private String queryId;
    private String cityName;
    private CountryCode countryCode;

}
