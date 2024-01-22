package com.cubeia.exceptions;


public class AccountNotFoundException extends CustomException {

    public AccountNotFoundException(Long id) {
        super("Could not find account with id: " + id);
    }
}
