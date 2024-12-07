package com.ss.cardsystem.registry;

import com.ss.cardsystem.models.Bus;
import com.ss.cardsystem.models.Transport;
import com.ss.cardsystem.models.Tube;
import com.ss.rental.Movie;

import java.util.HashMap;
import java.util.Map;

public class TransportRegistry {
    public enum TransportType {BUS, TUBE};
    private static final Map<String, TransportType> transportRegistry = new HashMap<>();

    public TransportRegistry() {
    }

    public static Transport getTransportType(String name) {
        return switch (transportRegistry.get(name)){
            case TUBE ->  new Tube(name);
            case BUS -> new Bus(name);
            default -> null;
        };
    }

    public static void addType(String name, TransportType type){
        transportRegistry.put(name, type);
    }
}