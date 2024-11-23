package com.ss.invoice.models;

public class PerformanceExt extends Performance {

    private Play play;
    private double amount;
    private int volumeCredit;

    public PerformanceExt(Performance performance) {
        setPlayID(performance.playID());
        setAudience(performance.audience());
    }

    public Play play() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    public double amount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int volumeCredit() {
        return volumeCredit;
    }

    public void setVolumeCredit(int volumeCredit) {
        this.volumeCredit = volumeCredit;
    }
}
