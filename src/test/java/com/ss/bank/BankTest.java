package com.ss.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BankTest {

    private BankAccount account;
    private Bank bank;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000);
        bank = new Bank();
    }

    @Test
    public void depositMoney() {
        account.deposit(1000);
        assertThat(account.balance(), is(2000));
        account.deposit(1000);
        assertThat(account.balance(), is(3000));
    }

    @Test
    public void rejectDeposit_whenAmountIsNegative() {
        Exception exception = Assertions.assertThrowsExactly(IllegalArgumentException.class,
                () -> account.deposit(-1000));

        assertThat(exception.getMessage(), is("amount should be positive"));
    }

    @Test
    public void withdrawMoney() {
        account.withdraw(500);

        assertThat(account.balance(), is(500));
    }

    @Test
    public void rejectWithdraw_whenAmountIsMoreThanBalance() {
        Exception exception = Assertions.assertThrowsExactly(IllegalArgumentException.class,
                () -> account.withdraw(1500));

        assertThat(exception.getMessage(), is("amount is more than available balance"));
    }

    @Test
    public void transferMoneyFromAccountAtoB() {
        BankAccount a = new BankAccount(2000);
        BankAccount b = new BankAccount(2000);


        bank.transfer(a, b, 1000);

        assertThat(a.balance(), is(1000));
        assertThat(b.balance(), is(3000));
    }

    @Test
    public void rejectTransfer_whenAmountMoreThanAvailableBalance() {
        BankAccount a = new BankAccount(100);
        BankAccount b = new BankAccount(2000);


        Exception exception = Assertions.assertThrowsExactly(IllegalArgumentException.class,
                () -> bank.transfer(a, b, 1000));

        assertThat(exception.getMessage(), is("insufficient balance is available"));
    }

}
