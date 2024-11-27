package com.ss.vs;

import java.util.ArrayList;
import java.util.List;

import static com.ss.vs.VideoRegistry.VideoType.CHILDERNS;
import static com.ss.vs.VideoRegistry.VideoType.REGULAR;

public class Customer {

    private final List<Rental> rentals = new ArrayList<>();

    public Customer() {
        VideoRegistry.addMovie("RegularMovie", REGULAR);
        VideoRegistry.addMovie("ChildrenMovie", CHILDERNS);
    }


    public void addRental(String title, int days) {
        rentals.add(new Rental(title, days));
    }

    public int getRentalFee() {
        int fee = 0;
        for (Rental rental : rentals) {
            fee += rental.getFee(rental);
        }
        return fee;
    }

    public int getRenterPoints() {
        int points = 0;
        for (Rental rental : rentals){
            points += rental.getPoints(rental);
        }
        return points;
    }

}
