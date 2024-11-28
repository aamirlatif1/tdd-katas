package com.ss.cardsystem.models;

import java.util.Arrays;
import java.util.List;

public class Station {
    private final String name;
    private final List<Integer> zones;

    public Station(String name, Integer... zones) {
        this.name = name;
        this.zones = Arrays.asList(zones);
    }

    public List<Integer> zones() {
        return zones;
    }
}
