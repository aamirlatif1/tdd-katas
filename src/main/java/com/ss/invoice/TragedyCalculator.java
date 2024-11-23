package com.ss.invoice;

import com.ss.invoice.models.Performance;
import com.ss.invoice.models.Play;

public class TragedyCalculator extends PerformanceCalculator {


    public TragedyCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    @Override
    public double amount() {
        double result = 40000.0;
        if (performance().audience() > 30) {
            result += 1000 * (performance().audience() - 30);
        }
        return result;

    }


}