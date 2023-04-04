package com.example.ContactManager.Exceptions;

public class NoSuchIdExistsException extends RuntimeException {

    public NoSuchIdExistsException() {}

    public NoSuchIdExistsException(String msg)
    {
        super(msg);
    }
}
