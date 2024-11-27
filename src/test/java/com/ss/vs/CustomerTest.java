package com.ss.vs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
    }

    private void assertFeeAndPoints(int rental, int points) {
        assertThat(customer.getRentalFee(), is(rental));
        assertThat(customer.getRenterPoints(), is(points));
    }

    @Test
    public void regularMovie_oneDay() {
        customer.addRental("RegularMovie", 1);
        assertFeeAndPoints(150, 1);
    }

    @Test
    public void regularMovie_secondAndThirdDayFree() {
        customer.addRental("RegularMovie", 3);
        assertFeeAndPoints(150, 1);
    }

    @Test
    public void regularMovie_fourDays() {
        customer.addRental("RegularMovie", 4);
        assertFeeAndPoints(300, 2);
    }

    @Test
    public void childrenMovie_oneDay() {
        customer.addRental("ChildrenMovie", 1);
        assertFeeAndPoints(100, 1);
    }

    @Test
    public void childrenMovie_fourDays() {
        customer.addRental("ChildrenMovie", 4);
        customer.addRental("RegularMovie", 4);
        assertFeeAndPoints(700, 3);
    }
}
