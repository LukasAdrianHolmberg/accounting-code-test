package com.cubeia.exceptions;

public class CustomException extends RuntimeException {
    // constructors

    private static final long serialVersionUID = 1L;

    public CustomException(String msg) {
        super(msg);
    }
}