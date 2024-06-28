package com.tcs.M_ManyToMany.exception;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
@AllArgsConstructor
public class ErrorResponse {
    private String error;
    private String message;
    private HttpStatus code;
}