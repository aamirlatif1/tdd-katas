package com.ss.invoice.models;

public class Performance {
    private String playID;
    private int audience;
    public Performance() {
    }
    public String playID() {
        return playID;
    }
    public int audience() {
        return audience;
    }
    public void setPlayID(String playID) {
        this.playID = playID;
    }
    public void setAudience(int audience) {
        this.audience = audience;
    }
}