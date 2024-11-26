package com.ss.rental;

public class NewReleasePrice extends Price {
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    int getFrequentRenterPoints(int  daysRented) {
        return daysRented > 1 ?  2: 1;
    }
}
