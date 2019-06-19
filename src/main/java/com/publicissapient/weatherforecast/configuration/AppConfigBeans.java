package com.publicissapient.weatherforecast.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfigBeans {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
