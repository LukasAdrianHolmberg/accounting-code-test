package com.cubeia.exceptions;


public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(Long id) {
        super("Could not find account with id: " + id);
    }
}
