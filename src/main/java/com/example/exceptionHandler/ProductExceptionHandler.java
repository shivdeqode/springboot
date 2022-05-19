package com.example.exceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<String> handlingJsonParseException(JsonParseException jsonParseException) {
       
        return new ResponseEntity<>("JSON Parse Exception Occured", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handlingNullPointerException(NullPointerException nullPointerException) {
        return new ResponseEntity<>("NullPointerException Occured", HttpStatus.OK);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handlingProductNotFoundException(ProductNotFoundException msg) {
        return new ResponseEntity<>("Product Not Found for the given ID", HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAnyException(Exception ex) {
        return new ResponseEntity<>(" Exception Occured", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
