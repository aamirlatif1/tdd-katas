package com.ss.invoice.models;

import java.util.List;

public class StatementData {
    private String customer;
    private List<PerformanceExt> performances;
    private double totalAmount;
    private int totalVolumeCredits;


    public String customer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<PerformanceExt> performances() {
        return performances;
    }

    public void setPerformances(List<PerformanceExt> performances) {
        this.performances = performances;
    }

    public double totalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int totalVolumeCredits() {
        return totalVolumeCredits;
    }

    public void setTotalVolumeCredits(int totalVolumeCredits) {
        this.totalVolumeCredits = totalVolumeCredits;
    }
}
