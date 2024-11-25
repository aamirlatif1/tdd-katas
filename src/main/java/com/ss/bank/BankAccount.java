package com.ss.bank;

public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        if (amount <= 0){
            throw new IllegalArgumentException("amount should be positive");
        }
        this.balance += amount;
    }

    public int balance() {
        return balance;
    }

    public void withdraw(int amount) {
        if (amount > balance){
            throw new IllegalArgumentException("amount is more than available balance");
        }
        balance -= amount;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
