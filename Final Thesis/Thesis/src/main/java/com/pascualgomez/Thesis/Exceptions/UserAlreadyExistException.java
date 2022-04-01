package com.pascualgomez.Thesis.Exceptions;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String username) {
        super("User with username '" + username + "' already exists");
    }
}