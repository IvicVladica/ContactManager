package com.example.ContactManager.Exceptions;

public class EmailValidationException extends RuntimeException{

    private String message;

    public EmailValidationException () {};

    public EmailValidationException (String msg) {
        super(msg);
        this.message = msg;
    }

}
