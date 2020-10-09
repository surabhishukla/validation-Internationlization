package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

    @ExceptionHandler(value = SpaceNotAllowed.class)
    public ResponseEntity<Object> exception(SpaceNotAllowed exception) {
        return new ResponseEntity<>("Space not allowed", HttpStatus.NOT_FOUND);
    }
}
