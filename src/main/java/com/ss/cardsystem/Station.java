package com.ss.cardsystem;

public class Station {
    private final String name;
    private final int zone;


    public Station(String name, int zone) {
        this.name = name;
        this.zone = zone;
    }

    public int zone() {
        return zone;
    }
}
