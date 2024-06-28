package com.tcs.M_ManyToMany.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoRecordsFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoRecordsFoundException(NoRecordsFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse("No records found", ex.getMessage(),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
