package theatricalplays;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    public static final NumberFormat usFormatter = NumberFormat.getCurrencyInstance(Locale.US);

    public String print(Invoice invoice, Map<String, Play> plays) {

        List<StatementLine> statementLines = calculateStatementLines(invoice, plays);
        
        var result = String.format("Statement for %s\n", invoice.customer);
        for (var statementLine : statementLines) {
            result += String.format("  %s: %s (%s seats)\n", statementLine.playName(),
                    usFormatter.format(statementLine.amount() / 100),
                    statementLine.audience());
        }

        result += String.format("Amount owed is %s\n", usFormatter.format(calculateTotalAmount(invoice, plays) / 100));
        result += String.format("You earned %s credits\n", calculateVolumeCredits(invoice, plays));
        return result;
    }

    private static List<StatementLine> calculateStatementLines(Invoice invoice, Map<String, Play> plays) {
        List<StatementLine> statementLines = new ArrayList<>();
        for (var perf : invoice.performances) {
            var play = plays.get(perf.playID);
            int thisAmount = calculatePerformanceAmount(perf, play);

            statementLines.add(new StatementLine(thisAmount, play.name, perf.audience));
        }
        return statementLines;
    }

    private static int calculateTotalAmount(Invoice invoice, Map<String, Play> plays) {
        var totalAmount = 0;
        for (var perf : invoice.performances) {
            var play = plays.get(perf.playID);
            int thisAmount = calculatePerformanceAmount(perf, play);
            totalAmount += thisAmount;
        }
        return totalAmount;
    }

    private static int calculateVolumeCredits(Invoice invoice, Map<String, Play> plays) {
        var volumeCredits = 0;
        for (var perf : invoice.performances) {
            var play = plays.get(perf.playID);
            volumeCredits += calculatePerformanceVolumeCredits(perf, play);
        }
        return volumeCredits;
    }

    private static int calculatePerformanceVolumeCredits(Performance perf, Play play) {
        int credits = Math.max(perf.audience - 30, 0);
        if ("comedy".equals(play.type)) credits += Math.floor(perf.audience / 5);
        return credits;
    }

    private static int calculatePerformanceAmount(Performance perf, Play play) {
        var thisAmount = 0;

        switch (play.type) {
            case "tragedy":
                thisAmount = 40000;
                if (perf.audience > 30) {
                    thisAmount += 1000 * (perf.audience - 30);
                }
                break;
            case "comedy":
                thisAmount = 30000;
                if (perf.audience > 20) {
                    thisAmount += 10000 + 500 * (perf.audience - 20);
                }
                thisAmount += 300 * perf.audience;
                break;
            default:
                throw new Error("unknown type: ${play.type}");
        }
        return thisAmount;
    }

}

record StatementLine(
    int amount,
    String playName,
    int audience
){}
