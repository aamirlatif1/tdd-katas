package com.ss.primefactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {

    public List<Integer> factors(int number) {
        List<Integer> factors = new ArrayList<>();
        if (number > 1) {
            factors.add(number);
        }
        return factors;
    }
}
