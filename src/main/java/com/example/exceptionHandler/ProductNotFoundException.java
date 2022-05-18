package com.example.exceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super();
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(Throwable cause) {
        super(cause);
    }
}
