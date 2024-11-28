package com.ss.cardsystem.registry;

import com.ss.cardsystem.models.Station;

import java.util.HashMap;
import java.util.Map;

public class StationRegistry {
    private static final Map<String, Station> stationMap = new HashMap<>();

    public StationRegistry() {

    }

    public static Station addStation(String stationName, Integer... zones) {
        return stationMap.put(stationName, new Station(stationName, zones));
    }

    public static Station getStation(String name) {
        return stationMap.get(name);
    }
}