package com.example.ContactManager.Exceptions;


    public class UserAlreadyExistsException
            extends RuntimeException {

        public UserAlreadyExistsException() {}

        public UserAlreadyExistsException(String msg)
        {
            super(msg);
        }
}
