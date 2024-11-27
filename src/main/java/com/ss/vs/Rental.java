package com.ss.vs;

import com.ss.vs.VideoRegistry.VideoType;

public class Rental {
    private final int days;
    private final VideoType type;
    private final Movie movie;

    public Rental(String title, int days) {
        this.movie = VideoRegistry.getMovie(title);
        this.days = days;
        this.type = VideoRegistry.getType(title);
    }

    public int getPoints(Rental rental) {
        return movie.getPoints(rental);
    }

    public int getFee(Rental rental) {
        return movie.getFee(rental);
    }


    public int days() {
        return days;
    }

}