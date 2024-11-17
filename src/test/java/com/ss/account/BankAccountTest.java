package com.ss.account;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class BankAccountTest {

    private Account myAccount;

    @Nested
    class SavingAccountContext {

        @BeforeEach
        void setUp() {
            myAccount = new SavingAccount();
        }

        @Test
        public void accountWithBalance100_earns3InInterest() {
            myAccount.setBalance(100.0);
            assertThat(myAccount.getInterestEarned(), is(closeTo(3.0, 0.001)));
        }
        @Test
        public void accountWithBalance200_earns6InInterest() {
            SavingAccount myAccount = new SavingAccount();
            myAccount.setBalance(200.0);
            assertThat(myAccount.getInterestEarned(), is(closeTo(6.0, 0.001)));
        }
    }

    @Nested
    class MoneyMarketAccountContext {

        @BeforeEach
        void setUp() {
            myAccount = new MoneyMarketAccount();
        }

        @Test
        public void accountWithBalance100_earns4InInterest() {
            myAccount.setBalance(100.0);
            assertThat(myAccount.getInterestEarned(), is(closeTo(4.0, 0.001)));
        }
        @Test
        public void accountWithBalance200_earns8InInterest() {
            myAccount.setBalance(200.0);
            assertThat(myAccount.getInterestEarned(), is(closeTo(8.0, 0.001)));
        }
    }

}
