package com.ss.romans;

import java.util.List;

public class RomanNumerals {

    private record RomanToDecimal(int decimal, String romanNumeral) {}


    private static final List<RomanToDecimal> romanMappings = List.of(
            new RomanToDecimal(1000, "M"),
            new RomanToDecimal(900, "CM"),
            new RomanToDecimal(400, "CD"),
            new RomanToDecimal(100, "C"),
            new RomanToDecimal(90, "XC"),
            new RomanToDecimal(50, "L"),
            new RomanToDecimal(40, "XL"),
            new RomanToDecimal(10, "X"),
            new RomanToDecimal(9, "IX"),
            new RomanToDecimal(5, "V"),
            new RomanToDecimal(4, "IV"),
            new RomanToDecimal(1, "I")
    );

    public String roman(int number) {
        StringBuilder roman = new StringBuilder();
        for (RomanToDecimal mapping : romanMappings) {
            while (number >= mapping.decimal) {
                roman.append(mapping.romanNumeral);
                number -= mapping.decimal;
            }
        }
        return roman.toString();
    }
}
