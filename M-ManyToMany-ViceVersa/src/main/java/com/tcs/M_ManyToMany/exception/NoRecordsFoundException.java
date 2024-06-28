package com.tcs.M_ManyToMany.exception;

public class NoRecordsFoundException extends RuntimeException {
    public NoRecordsFoundException(String message) {
        super(message);
    }
}