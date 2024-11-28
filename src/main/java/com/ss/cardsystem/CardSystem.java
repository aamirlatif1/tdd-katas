package com.ss.cardsystem;

import com.ss.cardsystem.registry.StationRegistry;
import com.ss.cardsystem.registry.TransportRegistry;
import com.ss.cardsystem.registry.TransportRegistry.TransportType;
import com.ss.cardsystem.models.Card;
import com.ss.cardsystem.models.Station;

import java.util.HashMap;
import java.util.Map;

import static com.ss.cardsystem.registry.TransportRegistry.TransportType.TUBE;


public class CardSystem {
    private final FarePolicy farePolicy = new FarePolicy();
    private final Map<Card, Travel> travels = new HashMap<>();

    public CardSystem() {

    }

    public void checkIn(Card card, String transportName, String station) {
        Travel travel = new Travel(StationRegistry.getStation(station), TransportRegistry.getTransportType(transportName), farePolicy.maxFare());

        if (card.balance() < farePolicy.maxFare()) {
            throw new IllegalArgumentException("insufficient balance");
        }
        card.setBalance(card.balance() - farePolicy.maxFare());
        travels.put(card, travel);
    }

    public void checkOut(Card card, String station) {
        Travel travel = travels.get(card);
        Station endStation = StationRegistry.getStation(station);
        int deduction = travel.maxFare;
        if (travel.type == TUBE) {
            deduction -= farePolicy.getFare(travel.from, endStation);
        } else {
            deduction -= 180;
        }
        card.setBalance(card.balance() + deduction);
        travels.remove(card);
    }

    private static class Travel {
        Station from;
        TransportType type;
        int maxFare;

        public Travel(Station from, TransportType type, int maxFare) {
            this.from = from;
            this.type = type;
            this.maxFare = maxFare;
        }
    }

}
