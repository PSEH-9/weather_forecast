package com.publicissapient.weatherforecast.repository;

import com.publicissapient.weatherforecast.model.QueryDetails;
import com.publicissapient.weatherforecast.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
public class WeatherQueryRepository {
    @Autowired
    RestTemplate restTemplate;

    @Value("${weather_fetch_base_url}")
    private String fetchWeatherBaseUrl;

    public WeatherResponse fetchWeatherDetails(QueryDetails queryDetails) {
        String absUrl = getParams().toUriString();
        WeatherResponse weatherResponse =
                restTemplate.getForObject(absUrl, WeatherResponse.class);
        return weatherResponse;
    }

    public UriComponentsBuilder getParams() {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(fetchWeatherBaseUrl)
                .queryParam("appid", "1ebac59dc9ed05795f6a822e372e3d02")
                .queryParam("q", "Bengaluru");
        return builder;
    }
}
