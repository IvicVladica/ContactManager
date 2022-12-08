package com.example.ContactManager.Exceptions;

public class NoSuchIdExistsException extends RuntimeException {
    private String message;

    public NoSuchIdExistsException() {}

    public NoSuchIdExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
