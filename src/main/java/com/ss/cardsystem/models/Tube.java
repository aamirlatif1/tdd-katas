package com.ss.cardsystem.models;

public class Tube extends Transport{
    public Tube(String title) {
        super(title);
    }

    @Override
    public int fare(Station from, Station to) {
        return  farePolicy.getFare(from, to);
    }
}
