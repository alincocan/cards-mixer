package com.shuffle.exceptions;

public class EmptyDeckException extends RuntimeException {

    private final String message;

    public EmptyDeckException() {
        this.message = "The deck is empty";
    }

    public EmptyDeckException(String message) {
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }

}
