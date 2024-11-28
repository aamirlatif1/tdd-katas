package com.ss.cardsystem.registry;

import java.util.HashMap;
import java.util.Map;

public class TransportRegistry {
    public enum TransportType {BUS, TUBE};
    private static final Map<String, TransportType> transportRegistry = new HashMap<>();

    public TransportRegistry() {
    }

    public static TransportType getTransportType(String name) {
        return transportRegistry.get(name);
    }

    public static void addType(String name, TransportType type){
        transportRegistry.put(name, type);
    }
}