package com.cubeia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "balance")
    private double Balance;


    public Account() {

    }

    public Account(double balance) {
        this.Balance = balance;
    }

    public long getId() {
        return id;
    }


    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        this.Balance = balance;
    }



    @Override
    public String toString() {
        return "Account [id=" + id + ", balance=" + Balance + "]";
    }

}
