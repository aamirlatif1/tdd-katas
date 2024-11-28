package com.ss.cardsystem;

import com.ss.cardsystem.models.Station;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FarePolicy {
    Map<Price, Integer> fareTable = new HashMap<>();

    public FarePolicy() {
        fareTable.put(new Price(1, 1), 250);
        fareTable.put(new Price(1, 2), 300);
        fareTable.put(new Price(1, 3), 320);

        fareTable.put(new Price(2, 1), 250);
        fareTable.put(new Price(2, 2), 225);
        fareTable.put(new Price(2, 3), 225);

        fareTable.put(new Price(3, 1), 320);
        fareTable.put(new Price(3, 2), 225);
        fareTable.put(new Price(3, 3), 225);
    }



    public int maxFare() {
        return 320;
    }

    public int getFare(Station fromStation, Station toStation) {
        int fare = Integer.MAX_VALUE;
        for (int fromZone : fromStation.zones()) {
            for (int toZone : toStation.zones()) {
                int np = fareTable.get(new Price(fromZone, toZone));
                if (np < fare)
                    fare = np;
            }
        }
        return fare;
    }

    private static class Price {
        int from;
        int to;

        public Price(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Price price = (Price) o;
            return from == price.from && to == price.to;
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }
}