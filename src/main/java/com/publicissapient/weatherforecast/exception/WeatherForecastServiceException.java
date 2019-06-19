package com.publicissapient.weatherforecast.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeatherForecastServiceException extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public WeatherForecastServiceException(String errorCode, String message) {
        super(message);
        log.error("Raised Exception - Error Code is : {} with error message as: {}", errorCode, errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorCode;
    }

    public ErrorDetails getErrorDetails() {
        return ErrorDetails.builder()
                .errorCode(errorCode)
                .errorMessage(errorMessage)
                .build();
    }

}
