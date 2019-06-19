package com.publicissapient.weatherforecast.controller;

import com.publicissapient.weatherforecast.exception.WeatherForecastServiceException;
import com.publicissapient.weatherforecast.model.QueryDetails;
import com.publicissapient.weatherforecast.service.WeatherQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherQueryController {

    @Autowired
    WeatherQueryService weatherQueryService;

    @PostMapping
    public ResponseEntity fetchWeather(@RequestBody QueryDetails queryDetails) {
        try {
            return new ResponseEntity(weatherQueryService.fetchWeatherDetails(queryDetails), HttpStatus.OK);
        } catch (WeatherForecastServiceException wfse) {
            return new ResponseEntity(wfse.getErrorDetails(), HttpStatus.OK);
        }
    }
}
