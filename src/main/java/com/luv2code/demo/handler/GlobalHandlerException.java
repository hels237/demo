package com.luv2code.demo.handler;

import com.luv2code.demo.exceptions.InvalidOperationException;
import com.luv2code.demo.exceptions.ObjectValidationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(EntityNotFoundException exception){

        ErrorResponse error = ErrorResponse.builder()
                                .message(exception.getMessage())
                                .source(exception.getClass().getName())
                                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ObjectValidationException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(ObjectValidationException exception){

        ErrorResponse error = ErrorResponse.builder().message(exception.getErrors()).violations(exception.getViolationSource()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


    @ExceptionHandler(InvalidOperationException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(InvalidOperationException exception){

        ErrorResponse error = ErrorResponse.builder().message(exception.getErrorMsg()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
