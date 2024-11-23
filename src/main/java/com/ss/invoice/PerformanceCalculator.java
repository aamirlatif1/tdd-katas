package com.ss.invoice;

import com.ss.invoice.models.Performance;
import com.ss.invoice.models.Play;

public abstract class PerformanceCalculator {
    private final Performance performance;
    private final Play play;

    public PerformanceCalculator(Performance performance, Play play) {
        this.performance = performance;
        this.play = play;
    }

    public abstract double amount();

    public int volumeCreditFor() {
        return Math.max(performance.audience() - 30, 0);
    }

    public Play play() {
        return play;
    }

    public Performance performance() {
        return performance;
    }
}