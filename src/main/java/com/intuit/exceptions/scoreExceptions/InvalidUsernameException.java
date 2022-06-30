package com.intuit.exceptions.scoreExceptions;

public class InvalidUsernameException extends ScoreException {
    public InvalidUsernameException() {
        super("Username is Required");
    }
}
