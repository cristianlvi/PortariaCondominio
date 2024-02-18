package com.cristian.portaria.project.exception.handler;

import com.cristian.portaria.project.exception.custons.ApartamentoException;
import com.cristian.portaria.project.exception.custons.ApiError;
import com.cristian.portaria.project.exception.custons.VerificaAndarException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionGlobalHandler {

    @ExceptionHandler(VerificaAndarException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handlerVerificaAndar(VerificaAndarException ex) {
        ApiError apiError = new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                ex.getMessage()
        );
        return ResponseEntity.status(apiError.getErrorCode()).body(apiError);
    }

    @ExceptionHandler(ApartamentoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handlerApartamentoException(ApartamentoException ex) {
        ApiError apiError = new ApiError(
                HttpStatus.NO_CONTENT.value(),
                LocalDateTime.now(),
                ex.getMessage()
        );
        return ResponseEntity.status(apiError.getErrorCode()).body(apiError);
    }


}
