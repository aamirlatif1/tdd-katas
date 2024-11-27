package com.ss.vs;

public class ChildrenMovie extends Movie{
    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    public int getPoints(Rental rental) {
        return 1;
    }

    @Override
    public int getFee(Rental rental) {
        return rental.days() * 100;
    }
}
