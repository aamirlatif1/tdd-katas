package com.ss.invoice;

import com.ss.invoice.models.Invoice;
import com.ss.invoice.models.Performance;
import com.ss.invoice.models.Play;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import static java.lang.String.format;
/**
 * Image a company of theatrical players who go out to various events performing plays.
 * Typically, a customer will request a few plays and the company charges them based on
 * the size of the audience and the kind of play they perform. There are currently two
 * kinds of plays that the company performs: tragedies and comedies. As well as providing
 * a bill for the performance, the company gives its customers “volume credits” which
 * they can use for discounts on future performances—think of it as a customer loyalty mechanism.
 *
 * <pre>
 * Future requirements:
 * 1. They want a statement printed in HTML
 * 2. The players are looking to perform more kinds of plays: they hope to add history, pastoral,
 *    pastoral-comical, historical- pastoral, tragical-historical, tragical-comical-historical-pastoral,
 *    scene individable, and poem unlimited to their repertoire. This change will affect both the
 *    way their plays are charged for and the way volume credits are calculated
 * <pre/>
 */
public class InvoiceGenerator {
    public String statement(final Invoice invoice, final Map<String, Play> plays) {
        var totalAmount = 0.0;
        var volumeCredits = 0;
        var result = format("Statement for %s%n", invoice.customer());
        final var currency = NumberFormat.getCurrencyInstance(Locale.US);
        for (Performance perf : invoice.performances()) {
            if (!plays.containsKey(perf.playID()))
                throw new IllegalArgumentException("performance with unknown play id: " + perf.playID());
            final var play = plays.get(perf.playID());
            double thisAmount;
            switch (play.type()) {
                case "tragedy" -> {
                    thisAmount = 40000.0;
                    if (perf.audience() > 30) {
                        thisAmount += 1000 * (perf.audience() - 30);
                    }
                }
                case "comedy" -> {
                    thisAmount = 30000.0;
                    if (perf.audience() > 20) {
                        thisAmount += 10000 + 500 * (perf.audience() - 20);
                    }
                    thisAmount += 300 * perf.audience();
                }
                default -> throw new IllegalArgumentException("unknown play type: " + play.type());
            }
            // add volume credits
            volumeCredits += Math.max(perf.audience() - 30, 0);
            // add extra credit for every ten comedy attendees
            if ("comedy".equals(play.type()))
                volumeCredits += perf.audience() / 5;
            // print line for this order
            result += format("  %s: %s (%d seats)%n", play.name(), currency.format(thisAmount / 100.0), perf.audience());
            totalAmount += thisAmount;
        }
        result += format("Amount owed is %s%n", currency.format(totalAmount / 100.0));
        result += format("You earned %d credits%n", volumeCredits);
        return result;
    }
}
