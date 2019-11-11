package com.nitroagility.graphql.dao.security;

public class InvalidCredentialsException extends Exception {

    public InvalidCredentialsException(String message) {
        super(message);
    }

}
