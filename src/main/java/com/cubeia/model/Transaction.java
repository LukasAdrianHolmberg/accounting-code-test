package com.cubeia.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;


    @Column(name = "time")
    private Date time;

    @Column(name = "input")
    private long input;

    @Column(name = "output")
    private long output;


    @Column(name = "amount")
    private double amount;


    public Transaction() {

    }

    public Transaction(long from, long to, double amount) {
        this.time = new Date();
        this.input = from;
        this.output = to;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public long getInput() {
        return this.input;
    }

    public void setInput (long input) {
        this.input = input;
    }

    public long getOutput() {
        return this.output;
    }

    public void setOutput (long output) {
        this.output = output;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return this.time;
    }



    @Override
    public String toString() {
        return "Transaction [id=" + id + ", input =" + this.input + ", output =" + this.output + ", time =" + time.toString() + ", amount =" + amount + "]";
    }

}
