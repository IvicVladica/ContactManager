package com.example.ContactManager.Exceptions;

public class EmailValidationException extends RuntimeException{

    public EmailValidationException () {}

    public EmailValidationException (String msg) {
        super(msg);
    }

}
