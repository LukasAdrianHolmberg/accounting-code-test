package com.cubeia.model;

public class Transfer {


    private final long input;

    private final long output;

    private final double amount;



    public Transfer(long input, long output, double amount) {
        this.input = input;

        this.output = output;

        this.amount = amount;

    }


    public long getInput() {
        return this.input;
    }


    public long getOutput() {
        return this.output;
    }


    public double getAmount() {
        return this.amount;
    }


}
