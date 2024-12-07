package com.ss.cardsystem;

import com.ss.cardsystem.models.Station;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FarePolicy {
    Map<Fare, Integer> fareTable = new HashMap<>();

    public FarePolicy() {
        fareTable.put(new Fare(1, 1), 250);
        fareTable.put(new Fare(1, 2), 300);
        fareTable.put(new Fare(1, 3), 320);

        fareTable.put(new Fare(2, 1), 250);
        fareTable.put(new Fare(2, 2), 225);
        fareTable.put(new Fare(2, 3), 225);

        fareTable.put(new Fare(3, 1), 320);
        fareTable.put(new Fare(3, 2), 225);
        fareTable.put(new Fare(3, 3), 225);
    }

    private static int applyAsInt(Integer v) {
        return v;
    }

    public int maxFare() {
        return fareTable.values().stream()
                .mapToInt(FarePolicy::applyAsInt)
                .max().orElse(0);
    }

    public int getFare(Station fromStation, Station toStation) {
        int fare = Integer.MAX_VALUE;
        for (int fromZone : fromStation.zones()) {
            for (int toZone : toStation.zones()) {
                int np = fareTable.get(new Fare(fromZone, toZone));
                if (np < fare)
                    fare = np;
            }
        }
        return fare;
    }

    private static class Fare {
        int from;
        int to;

        public Fare(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Fare fare = (Fare) o;
            return from == fare.from && to == fare.to;
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }
}