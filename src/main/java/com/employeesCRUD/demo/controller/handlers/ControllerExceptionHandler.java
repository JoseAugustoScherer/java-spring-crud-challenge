package com.employeesCRUD.demo.controller.handlers;

import com.employeesCRUD.demo.dto.CustomError;
import com.employeesCRUD.demo.dto.ValidationError;
import com.employeesCRUD.demo.service.Exceptions.DatabaseException;
import com.employeesCRUD.demo.service.Exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

/**
 * @author José Augusto Scherer - jose.a.scherer@gmail.com
 * @file ControllerExceptionHandler
 * @since 23/10/2025 - 15:14
 */

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> exceptionHandler(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError( Instant.now(), status.value(), e.getMessage(), request.getRequestURI() );
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler (DatabaseException.class)
    public ResponseEntity<CustomError> databaseException(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError err = new CustomError( Instant.now(), status.value(), e.getMessage(), request.getRequestURI() );
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err = new ValidationError( Instant.now(), status.value(), "Invalid data", request.getRequestURI() );

        for ( FieldError f : e.getBindingResult().getFieldErrors() ) {
            err.addError( f.getField(), f.getDefaultMessage() );
        }

        return ResponseEntity.status(status).body(err);
    }
}
