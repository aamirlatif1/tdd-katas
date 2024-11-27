package com.ss.vs;

import static com.ss.vs.VideoRegistry.VideoType.REGULAR;

public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public int getPoints(Rental rental) {
        return applyGracePeriod(1, rental.days(), 3);
    }

    @Override
    public int getFee(Rental rental) {
        return applyGracePeriod(150, rental.days(), 3);
    }
}
