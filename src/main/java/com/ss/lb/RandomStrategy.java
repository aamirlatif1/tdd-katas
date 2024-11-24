package com.ss.lb;

import java.util.Random;

public class RandomStrategy implements SelectionStrategy {
    private final Random randomSelector;

    public RandomStrategy(Random random) {
        this.randomSelector = random;
    }

    @Override
    public int next(int size) {
        return randomSelector.nextInt(size);
    }
}
