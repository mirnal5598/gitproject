package com.example.demo.exception;

import java.util.Date;
//ResponseExceptionHandler(present in spring)-> abstract class can be extended to provide centralised
// exception handling across all the diff exception methods

public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

}
