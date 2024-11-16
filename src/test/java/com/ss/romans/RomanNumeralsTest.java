package com.ss.romans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RomanNumeralsTest {

    private RomanNumerals romanNumerals;

    @BeforeEach
    void setUp() {
        romanNumerals = new RomanNumerals();
    }

    @Test
    public void numbersWithI() throws Exception {
        Assertions.assertEquals("I", romanNumerals.roman(1));
        Assertions.assertEquals("II", romanNumerals.roman(2));
        Assertions.assertEquals("III", romanNumerals.roman(3));
    }

    @Test
    public void romansWithV() throws Exception {
        Assertions.assertEquals("IV", romanNumerals.roman(4));
        Assertions.assertEquals("V", romanNumerals.roman(5));
        Assertions.assertEquals("VI", romanNumerals.roman(6));
        Assertions.assertEquals("VII", romanNumerals.roman(7));
        Assertions.assertEquals("VIII", romanNumerals.roman(8));
    }

    @Test
    public void romansWithX() throws Exception {
        Assertions.assertEquals("IX", romanNumerals.roman(9));
        Assertions.assertEquals("X", romanNumerals.roman(10));
        Assertions.assertEquals("XI", romanNumerals.roman(11));
        Assertions.assertEquals("XX", romanNumerals.roman(20));
        Assertions.assertEquals("XXX", romanNumerals.roman(30));
        Assertions.assertEquals("XXXIV", romanNumerals.roman(34));
    }
    
    @Test
    public void romanWithL() throws Exception {
        Assertions.assertEquals("XL", romanNumerals.roman(40));
        Assertions.assertEquals("L", romanNumerals.roman(50));
        Assertions.assertEquals("LX", romanNumerals.roman(60));
    }

    @Test
    public void romanWithC() throws Exception {
        Assertions.assertEquals("XC", romanNumerals.roman(90));
        Assertions.assertEquals("C", romanNumerals.roman(100));
    }
    
    @Test
    public void mixNumbers() throws Exception {
        Assertions.assertEquals("MCMXC", romanNumerals.roman(1990));
        Assertions.assertEquals("MMVIII", romanNumerals.roman(2008));
        Assertions.assertEquals("XCIX", romanNumerals.roman(99));
    }

}
