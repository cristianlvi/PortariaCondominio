package com.cristian.portaria.project.exception;

import com.cristian.portaria.project.exception.custons.*;
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

    @ExceptionHandler(UserException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<?> handlerUserExiste(UserException ex) {
        ApiError apiError = new ApiError(
                HttpStatus.FORBIDDEN.value(),
                LocalDateTime.now(),
                ex.getMessage()
        );
        return ResponseEntity.status(apiError.getErrorCode()).body(apiError);
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<?> handlerErroLoginUser(AuthenticationException ex) {
        ApiError apiError = new ApiError(
                HttpStatus.FORBIDDEN.value(),
                LocalDateTime.now(),
                ex.getMessage()
        );
        return ResponseEntity.status(apiError.getErrorCode()).body(apiError);


    }


}
