package com.latebox.server.account;


public class AccountNotFoundException extends RuntimeException {
    AccountNotFoundException(Long id) {
        super("Could not find account " + id);
    }
}
