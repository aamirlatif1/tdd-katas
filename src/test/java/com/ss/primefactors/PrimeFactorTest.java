package com.ss.primefactors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimeFactorTest {

    private PrimeFactor primeFactor;

    @BeforeEach
    void setUp() {
        primeFactor = new PrimeFactor();
    }

    @Test
    public void testPrimeFactors() {

        assertEquals(List.of(), primeFactor.factors(1));
        assertPrimeFactor(2, 2);
    }

    private void assertPrimeFactor(int number, int ...factors ) {
        assertEquals(new ArrayList<>(), primeFactor.factors(number));
    }
}
