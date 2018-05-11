package com.shuffle.exceptions;

public class OutOfDeckException extends RuntimeException {

    private final String message;

    public OutOfDeckException() {
        this.message = "The position is out of deck";
    }

    public OutOfDeckException(String message) {
        this.message = message;
    }



    @Override
    public String getMessage() {
        return message;
    }


}
