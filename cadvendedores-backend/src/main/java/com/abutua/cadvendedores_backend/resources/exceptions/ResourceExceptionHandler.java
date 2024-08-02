package com.abutua.cadvendedores_backend.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.abutua.cadvendedores_backend.services.exceptions.DatabaseException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ValidationErrors> validationException(MethodArgumentNotValidException exception, HttpServletRequest request) {
    
    ValidationErrors error = new ValidationErrors();
    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

    error.setTimeStamp(Instant.now());
    error.setError("Validation error");
    error.setMessage(exception.getMessage());
    error.setStatus(status.value());
    error.setPath(request.getRequestURI());

    exception.getBindingResult()
             .getFieldErrors()
             .forEach(e -> error.addErrors(e.getDefaultMessage()));

    return ResponseEntity.status(status).body(error);
  }

  @ExceptionHandler(DatabaseException.class)
  public ResponseEntity<StandardError> databaseException(DatabaseException exception, HttpServletRequest request) {
    
    StandardError error = new StandardError();
    HttpStatus status = HttpStatus.BAD_REQUEST;

    error.setTimeStamp(Instant.now());
    error.setError("Database exception");
    error.setMessage(exception.getMessage());
    error.setStatus(status.value());
    error.setPath(request.getRequestURI());

    return ResponseEntity.status(status).body(error);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<StandardError> entityNotFoundException(EntityNotFoundException exception, HttpServletRequest request) {
    
    StandardError error = new StandardError();
    HttpStatus status = HttpStatus.NOT_FOUND;

    error.setTimeStamp(Instant.now());
    error.setError("Ressource not found");
    error.setMessage(exception.getMessage());
    error.setStatus(status.value());
    error.setPath(request.getRequestURI());

    return ResponseEntity.status(status).body(error);
  }
}
