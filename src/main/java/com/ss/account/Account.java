package com.ss.account;

public abstract class Account {
    private double balance;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestEarned(){
        return balance * getInterestRate();
    }

    protected abstract double getInterestRate();
}
