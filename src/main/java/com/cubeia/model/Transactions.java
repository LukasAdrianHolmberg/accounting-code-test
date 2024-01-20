package com.cubeia.model;

import com.cubeia.model.Transaction;

import java.util.List;


public class Transactions {

    private final List<Transaction> transactions;

    private final int length;

    public Transactions(List<Transaction> transactions) {
        this.transactions = transactions;
        this.length = this.transactions.size();
    }


    public List<Transaction> getTransactions() {
        return transactions;
    }

    public int getLength() {
        return length;
    }
}
