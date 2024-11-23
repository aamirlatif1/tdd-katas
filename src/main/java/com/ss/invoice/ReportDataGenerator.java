package com.ss.invoice;

import com.ss.invoice.models.*;

import java.util.Map;

public class ReportDataGenerator {

    public ReportDataGenerator() {
    }

    public StatementData generate(Invoice invoice, Map<String, Play> plays) {
        StatementData data = new StatementData();
        data.setCustomer(invoice.customer());
        data.setPerformances(invoice.performances().stream().map(p -> enrichPerformance(p, plays)).toList());
        data.setTotalAmount(totalAmount(data));
        data.setTotalVolumeCredits(totalVolumeCredits(data));
        return data;
    }

    private PerformanceExt enrichPerformance(Performance aPerformance, Map<String, Play> plays) {
        PerformanceExt result = new PerformanceExt(aPerformance);
        if (!plays.containsKey(result.playID())) {
            throw new IllegalArgumentException("performance with unknown play id: " + result.playID());
        }
        PerformanceCalculator calculator = createPerformanceCalculator(aPerformance, playFor(plays, aPerformance));
        result.setPlay(calculator.play());
        result.setAmount(calculator.amount());
        result.setVolumeCredit(calculator.volumeCreditFor());
        return result;
    }

    private PerformanceCalculator createPerformanceCalculator(Performance aPerformance, Play play) {
        switch (play.type()) {
            case "tragedy" -> {
                return new TragedyCalculator(aPerformance, play);
            }
            case "comedy" -> {
                return new ComedyCalculator(aPerformance, play);
            }
            default -> throw new IllegalArgumentException("unknown play type: " + play.type());
        }
    }

    private double totalAmount(StatementData data) {
        var result = 0.0;
        for (PerformanceExt perf : data.performances()) {
            result += perf.amount();
        }
        return result;
    }

    private int totalVolumeCredits(StatementData data) {
        var result = 0;
        for (PerformanceExt perf : data.performances()) {
            result += perf.volumeCredit();
        }
        return result;
    }


    private Play playFor(Map<String, Play> plays, Performance aPerformance) {
        return plays.get(aPerformance.playID());
    }

}