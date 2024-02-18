package com.cristian.portaria.project.exception.custons;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiError {

    private int errorCode;
    private LocalDateTime timestamp;
    private String message;

    public ApiError(int errorCode, LocalDateTime timestamp, String message) {
        this.errorCode = errorCode;
        this.timestamp = timestamp;
        this.message = message;
    }
}
