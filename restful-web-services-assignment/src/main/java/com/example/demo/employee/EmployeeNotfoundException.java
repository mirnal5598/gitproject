package com.example.demo.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotfoundException extends RuntimeException {

    public EmployeeNotfoundException(String message) {
        super(message);
    }
}
