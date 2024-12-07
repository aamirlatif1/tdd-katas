package com.ss.cardsystem;

import com.ss.cardsystem.models.Transport;
import com.ss.cardsystem.registry.StationRegistry;
import com.ss.cardsystem.registry.TransportRegistry;
import com.ss.cardsystem.models.Card;
import com.ss.cardsystem.models.Station;

import java.util.HashMap;
import java.util.Map;


public class CardSystem {
    ;
    private final Map<Card, Travel> travels = new HashMap<>();

    public CardSystem() {

    }

    public void checkIn(Card card, String transportName, String station) {
        Travel travel = new Travel(StationRegistry.getStation(station), TransportRegistry.getTransportType(transportName));

        if (card.balance() < travel.transport.maxFare()) {
            throw new IllegalArgumentException("insufficient balance");
        }
        card.setBalance(card.balance() - travel.transport.maxFare());
        travels.put(card, travel);
    }

    public void checkOut(Card card, String station) {
        Travel travel = travels.get(card);

        int refundAmount = travel.calculateRefund(StationRegistry.getStation(station));
        card.setBalance(card.balance() + refundAmount);
        travels.remove(card);
    }

    private static class Travel {
        Station from;
        Transport transport;

        public Travel(Station from, Transport transport) {
            this.from = from;
            this.transport = transport;
        }

        int calculateRefund(Station to) {
            int deduction = transport.maxFare();
            return deduction - transport.fare(from, to);
        }
    }

}
