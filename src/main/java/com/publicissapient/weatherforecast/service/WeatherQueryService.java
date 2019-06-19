package com.publicissapient.weatherforecast.service;

import com.publicissapient.weatherforecast.exception.WeatherForecastServiceException;
import com.publicissapient.weatherforecast.model.QueryDetails;
import com.publicissapient.weatherforecast.model.WeatherResponse;
import com.publicissapient.weatherforecast.repository.WeatherQueryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class WeatherQueryService {

    @Autowired
    WeatherQueryRepository weatherQueryRepository;

    public WeatherResponse fetchWeatherDetails(QueryDetails queryDetails)
            throws WeatherForecastServiceException {
        return weatherQueryRepository.fetchWeatherDetails(queryDetails);

    }
}
