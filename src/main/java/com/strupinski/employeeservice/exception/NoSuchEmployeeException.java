package com.strupinski.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchEmployeeException extends RuntimeException{

    public NoSuchEmployeeException(String message) {
        super(message);
    }

}
