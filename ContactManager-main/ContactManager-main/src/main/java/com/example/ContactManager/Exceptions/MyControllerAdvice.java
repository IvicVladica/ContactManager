package com.example.ContactManager.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNotFound(NullPointerException nullPointerException) {
        return new ResponseEntity<String>("Empty fields not allowed", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchIdExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleNoSuchElement(NoSuchIdExistsException noSuchContactExistException) {
        return new ResponseEntity<String>("Not found with that ID", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handleAlreadyExists(UserAlreadyExistsException userAlreadyExistsException){
        return new ResponseEntity<String>("Email already exist", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EmailValidationException.class)
    public ResponseEntity<String> handleEmailValidation(EmailValidationException emailValidationException) {
        return new ResponseEntity<String>("Email must be valid", HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>("Please change your request type", HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<String> handleValidationErrors(MethodArgumentNotValidException e) {
//        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//   }

}
