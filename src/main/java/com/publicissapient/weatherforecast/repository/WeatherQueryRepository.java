package com.publicissapient.weatherforecast.repository;

import com.publicissapient.weatherforecast.exception.WeatherForecastServiceException;
import com.publicissapient.weatherforecast.model.QueryDetails;
import com.publicissapient.weatherforecast.model.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
@Slf4j
public class WeatherQueryRepository {
    @Autowired
    RestTemplate restTemplate;

    @Value("${weather_fetch_base_url}")
    private String fetchWeatherBaseUrl;
    @Value("${apiKey}")
    private String apiKey;
    @Value("${default_city}")
    private String defaultCity;

    public WeatherResponse fetchWeatherDetails(QueryDetails queryDetails) throws WeatherForecastServiceException{
        log.info("fetchWeatherDetails() invoked in WeatherQueryRepository with payload = {}", queryDetails);
        try {
            WeatherResponse weatherResponse =
                    restTemplate.getForObject(makeAndReturnUrl(queryDetails).toUriString(), WeatherResponse.class);
            weatherResponse.setAlertText("Nothing To Alert!!");
            return weatherResponse;
        } catch (Exception ee) {
            throw new WeatherForecastServiceException("WEA_FRS_001", "Error In Fetching Data");
        }
    }

    public UriComponentsBuilder makeAndReturnUrl(QueryDetails queryDetails) {
        UriComponentsBuilder queryBuilder = UriComponentsBuilder.fromHttpUrl(fetchWeatherBaseUrl)
                .queryParam("appid", apiKey)
                .queryParam("q", queryDetails.getCityName() == null ? defaultCity : queryDetails.getCityName());
        return queryBuilder;
    }
}
