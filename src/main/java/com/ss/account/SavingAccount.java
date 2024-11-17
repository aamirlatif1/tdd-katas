package com.ss.account;

public class SavingAccount extends Account {

    @Override
    protected double getInterestRate() {
        return 0.03;
    }
}
