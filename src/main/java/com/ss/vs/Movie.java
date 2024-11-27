package com.ss.vs;


public abstract class Movie {
    final String title;

    public Movie(String title) {
        this.title = title;
    }

    public abstract int getPoints(Rental rental);

    public abstract int getFee(Rental rental);

    public static int applyGracePeriod(int amount, int days, int grace) {
        if (days > grace)
            amount = amount + amount * (days - grace);
        return amount;
    }

    public String title() {
        return title;
    }
}