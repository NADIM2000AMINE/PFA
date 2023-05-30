package com.pfa.exception;

public class userNotFoundException extends Throwable {
    public userNotFoundException(Integer id) {
        super("Could not found the user with id "+ id);
    }
}
