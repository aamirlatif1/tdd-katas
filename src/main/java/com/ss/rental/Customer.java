package com.ss.rental;

import java.util.ArrayList;
import java.util.List;

class Customer {
    private final String _name;
    private final List<Rental> _rentals = new ArrayList<>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        for (Rental rental : _rentals) {
            result.append("\t").append(rental.getMovie().getTitle())
                    .append("\t").append(rental._movie.getCharge(rental.getDaysRented())).append("\n");
        }
        //add footer lines
        result.append("Amount owed is ").append(totalCharges()).append("\n");
        result.append("You earned ").append(totalFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
    }

    private double totalCharges() {
        double result = 0;
        for (Rental rental : _rentals) {
            result += rental._movie.getCharge(rental.getDaysRented());
        }
        return result;
    }

    private int totalFrequentRenterPoints() {
        int result = 0;
        for (Rental rental : _rentals) {
            result += rental._movie.price().getFrequentRenterPoints(rental.getDaysRented());
        }
        return result;
    }

}