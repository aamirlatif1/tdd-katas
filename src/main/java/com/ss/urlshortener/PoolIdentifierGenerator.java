package com.ss.urlshortener;

import java.util.List;

public class PoolIdentifierGenerator implements IdentifierGenerator {
    private final List<String> pool;

    public PoolIdentifierGenerator(List<String> pool) {
        this.pool = pool;
    }

    @Override
    public String generateIdentifier() {
        if (pool.isEmpty()) {
            throw new IllegalStateException("no more identifiers available");
        }
        return pool.remove(0);
    }
}
