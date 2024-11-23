package com.ss.invoice;

import com.ss.invoice.models.*;

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
        return renderPlainText(new ReportDataGenerator().generate(invoice, plays));
    }

    public String htmlStatement(Invoice invoice, Map<String, Play> plays) {
        return renderHTML(new ReportDataGenerator().generate(invoice, plays));
    }

    private String renderPlainText(StatementData data) {
        var result = new StringBuilder(format("Statement for %s%n", data.customer()));
        for (PerformanceExt perf : data.performances()) {
            result.append(format("  %s: %s (%d seats)%n", perf.play().name(), usd(perf.amount()), perf.audience()));
        }
        result.append(format("Amount owed is %s%n", usd(data.totalAmount())));
        result.append(format("You earned %d credits%n", data.totalVolumeCredits()));
        return result.toString();
    }

    private String renderHTML(StatementData data) {
        var result = new StringBuilder(format("<h1>Statement for %s</h1>%n", data.customer()));
        result.append("<table>\n<tr><th>play</th><th>seats</th><th>cost</th></tr>\n");
        for (PerformanceExt perf : data.performances()) {
            result.append(format("<tr><td>%s</td><td>%s</td><td>%d</td></tr>%n", perf.play().name(), usd(perf.amount()), perf.audience()));
        }
        result.append("</table>\n");
        result.append(format("<p>Amount owed is <em>%s</em></p>%n", usd(data.totalAmount())));
        result.append(format("<p>You earned <em>%d</em> credits</p>%n", data.totalVolumeCredits()));
        return result.toString();
    }

    private String usd(double totalAmount) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(totalAmount / 100.0);
    }

}
