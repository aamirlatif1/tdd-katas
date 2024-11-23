package com.ss.invoice;

import com.ss.invoice.models.Performance;
import com.ss.invoice.models.Play;

public class ComedyCalculator extends PerformanceCalculator{

    public ComedyCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    @Override
    public int volumeCreditFor() {
       return super.volumeCreditFor()  + performance().audience() / 5;
    }

    @Override
    public double amount() {
        var result = 30000.0;
        if (performance().audience() > 20) {
            result += 10000 + 500 * (performance().audience() - 20);
        }
        result += 300 * performance().audience();
        return result;
    }
}
