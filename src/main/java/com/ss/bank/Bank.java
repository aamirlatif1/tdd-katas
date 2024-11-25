package com.ss.bank;

public class Bank {

    public void transfer(BankAccount from, BankAccount to, int amount) {
        if (from.balance() < amount) {
            throw new IllegalArgumentException("insufficient balance is available");
        }
        from.setBalance(from.balance() - amount);
        to.setBalance(to.balance() + amount);
    }
}
