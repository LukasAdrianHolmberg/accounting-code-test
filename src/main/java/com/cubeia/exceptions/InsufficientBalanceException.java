package com.cubeia.exceptions;



public class InsufficientBalanceException extends CustomException {

    public InsufficientBalanceException() {
        super("Insufficient balance");
    }
}