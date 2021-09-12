package com.itrex.java.lab.exception;

public class ValidationException extends Exception {

    private final int numEven;

    public ValidationException(int numEven, String msg) {
        super(msg);
        this.numEven = numEven;
    }

    public int getNumEven() {
        return numEven;
    }

}
