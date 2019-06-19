package com.publicissapient.weatherforecast.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDetails {
    private String errorCode;
    private String errorMessage;
}
