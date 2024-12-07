package com.ss.cardsystem.models;

public class Bus extends Transport {
    public Bus(String title) {
        super(title);
    }

    @Override
    public int fare(Station from, Station to) {
        return 180;
    }
}
