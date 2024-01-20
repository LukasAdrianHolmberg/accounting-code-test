package com.cubeia.model;

import java.util.List;


public class Transactions {

    private final List<Transaction> transactions;

    private final int length;

    public Transactions(List<Transaction> transactions) {
        this.transactions = transactions;
        this.length = this.transactions.size();
    }

}
