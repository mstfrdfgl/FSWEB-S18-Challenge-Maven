package com.workintech.fswebs18challengemaven.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Data
@ControllerAdvice
public class CardException extends RuntimeException{

    private HttpStatus httpStatus;

    public CardException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    @ExceptionHandler
    public ResponseEntity<CardErrorResponse> handleException(IllegalArgumentException exception) {
        CardErrorResponse response = new CardErrorResponse(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
