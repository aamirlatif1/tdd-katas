package com.ss.urlshortener;

public class SequenceIdentifierGenerator implements IdentifierGenerator {
    int sequence = 1;

    public SequenceIdentifierGenerator() {
    }

    @Override
    public String generateIdentifier() {
        return "" + sequence++;
    }
}