package com.example.ContactManager.Exceptions;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNotFound(NullPointerException nullPointerException) {
        return new ResponseEntity<String>("Not found", HttpStatus.NOT_FOUND);
    }


    
}
