package com.pascualgomez.Thesis.Exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("User with username '" + username + "' has not been found.");
    }
}
