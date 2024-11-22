package com.ss.cardsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class FareCalculatorTest {

    private Station helborn;
    private Station earlsCourt;
    private FareCalculator fareCalculator;
    private Station hammersmith;

    @BeforeEach
    void setUp() {
        helborn = new Station("Holborn", 1);
        earlsCourt = new Station("Earl’s Court", 1);
        fareCalculator = new FareCalculator();
        hammersmith = new Station("Hammersmith", 2);
    }

    @Test
    public void fareInWithinZone1() {
        int fare = fareCalculator.calculate(helborn, earlsCourt);
        assertThat(fare, equalTo(250));
    }

    @Test
    public void fareInWithinZone2() {
        int fare = fareCalculator.calculate(earlsCourt, hammersmith);
        assertThat(fare, equalTo(200));

    }


}
