package com.ss.cardsystem;

public class FareCalculator {
    public int calculate(Station frome, Station to) {
        if (frome.zone() == 1 && to.zone() == 1) {
            return 250;
        } else  {
            return 200;
        }
    }
}
