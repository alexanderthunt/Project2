package com.revature.project1.controllers;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.revature.project1.exceptions.IncorrectPasswordException;
import com.revature.project1.exceptions.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<String> sqlExceptionFound(SQLException e) {
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userNotFound(UserNotFoundException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<String> incorrectPassword(IncorrectPasswordException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.UNAUTHORIZED);
    }

}
