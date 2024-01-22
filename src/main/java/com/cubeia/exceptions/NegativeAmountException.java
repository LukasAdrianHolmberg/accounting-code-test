package com.cubeia.exceptions;

public class NegativeAmountException extends CustomException{

    public NegativeAmountException() {
        super("Amount is negative");
    }
}
