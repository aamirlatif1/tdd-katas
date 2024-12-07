package com.ss.cardsystem.models;

import com.ss.cardsystem.FarePolicy;

public abstract class Transport {
    protected final static FarePolicy farePolicy = new FarePolicy();
    private final String title;

    public Transport(String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }

    public int maxFare() {
        return farePolicy.maxFare();
    }

    public abstract int fare(Station from, Station to);
}
