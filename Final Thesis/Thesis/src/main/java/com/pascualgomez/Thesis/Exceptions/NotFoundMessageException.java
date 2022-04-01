package com.pascualgomez.Thesis.Exceptions;

public class NotFoundMessageException extends RuntimeException {

    public NotFoundMessageException(Long id) {
        super("Message with id " + id + " could not be found.");
    }
}