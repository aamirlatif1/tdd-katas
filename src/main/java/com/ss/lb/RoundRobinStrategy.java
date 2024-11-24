package com.ss.lb;

public class RoundRobinStrategy implements SelectionStrategy {
    int index = 0;

    public RoundRobinStrategy() {
    }

    @Override
    public int next(int size) {
        return index++ % size;
    }
}