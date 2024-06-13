package theatricalplays;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    public String print(Invoice invoice, Map<String, Play> plays) {
        Statement statement = calculateStatement(invoice, plays);
        return printAsText(invoice, plays, statement);
    }

    private static String printAsText(Invoice invoice, Map<String, Play> plays, Statement statement) {
        var textStatement = String.format("Statement for %s\n", invoice.customer);
        NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);
        for (Performance performance : invoice.performances) {
            var play = plays.get(performance.playID);

            // print line for this order
            textStatement += String.format("  %s: %s (%s seats)\n", play.name, frmt.format(performance.amount / 100), performance.audience);
        }

        textStatement += String.format("Amount owed is %s\n", frmt.format(statement.totalAmount() / 100));
        textStatement += String.format("You earned %s credits\n", statement.totalVolumeCredits());
        return textStatement;
    }

    private Statement calculateStatement(Invoice invoice, Map<String, Play> plays) {
        calculatePerformancesAmount(invoice, plays);
        int totalAmount = calculateTotalAmount(invoice, plays);
        int totalVolumeCredits = calculateTotalVolumeCredits(invoice, plays);
        return new Statement(totalAmount, totalVolumeCredits);
    }

    private static void calculatePerformancesAmount(Invoice invoice, Map<String, Play> plays) {
        for (Performance performance : invoice.performances) {
            var play = plays.get(performance.playID);
            var performanceAmount = calculatePerformanceAmount(performance, play);
            performance.setAmount(performanceAmount);
        }
    }

    private static int calculateTotalAmount(Invoice invoice, Map<String, Play> plays) {
        int totalAmount = 0;
        for (var performance : invoice.performances) {
            var play = plays.get(performance.playID);
            var performanceAmount = calculatePerformanceAmount(performance, play);

            // add total amount
            totalAmount += performanceAmount;
        }
        return totalAmount;
    }

    private static int calculateTotalVolumeCredits(Invoice invoice, Map<String, Play> plays) {
        int volumeCredits = 0;
        for (var performance : invoice.performances) {
            var play = plays.get(performance.playID);
            volumeCredits += calculatePerformanceVolumeCredits(performance, play);
        }
        return volumeCredits;
    }

    private static int calculatePerformanceAmount(Performance performance, Play play) {
        var amount = 0;

        switch (play.type) {
            case "tragedy":
                amount = 40000;
                if (performance.audience > 30) {
                    amount += 1000 * (performance.audience - 30);
                }
                break;
            case "comedy":
                amount = 30000;
                if (performance.audience > 20) {
                    amount += 10000 + 500 * (performance.audience - 20);
                }
                amount += 300 * performance.audience;
                break;
            default:
                throw new Error("unknown type: ${play.type}");
        }
        return amount;
    }

    private static int calculatePerformanceVolumeCredits(Performance performance, Play play) {
        var performanceVolumeCredits = 0;
        performanceVolumeCredits += Math.max(performance.audience - 30, 0);
        // add extra credit for every ten comedy attendees
        if ("comedy".equals(play.type)) performanceVolumeCredits += Math.floor(performance.audience / 5);
        return performanceVolumeCredits;
    }

}

