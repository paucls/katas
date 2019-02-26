export function statement(invoice, plays) {
    let totalAmount = 0;
    let result = `Statement for ${invoice.customer}\n`;

    for (let performance of invoice.performances) {
        let amount = calculatePerformanceAmount(performance);
        // print line for this order
        result += `  ${playOf(performance).name}: ${formatUSD(amount)} (${performance.audience} seats)\n`;

        totalAmount += amount;
    }

    let volumeCredits = 0;
    for (let performance of invoice.performances) {
        volumeCredits += calculateVolumeCreditsForPerformance(performance);
    }

    result += `Amount owed is ${formatUSD(totalAmount)}\n`;

    result += `You earned ${volumeCredits} credits\n`;

    return result;

    function calculatePerformanceAmount(performance) {
        let perfAmount = 0;

        switch (playOf(performance).type) {
            case 'tragedy':
                perfAmount = 40000;
                if (performance.audience > 30) {
                    perfAmount += 1000 * (performance.audience - 30);
                }
                break;
            case 'comedy':
                perfAmount = 30000;
                if (performance.audience > 20) {
                    perfAmount += 10000 + 500 * (performance.audience - 20);
                }
                perfAmount += 300 * performance.audience;
                break;
            default:
                throw new Error(`unknown type: ${playOf(performance).type}`);
        }
        return perfAmount;
    }

    function calculateVolumeCreditsForPerformance(performance) {
        let credits = Math.max(performance.audience - 30, 0);
        if ('comedy' === playOf(performance).type) credits += Math.floor(performance.audience / 5);
        return credits;
    }

    function playOf(performance) {
        return plays[performance.playID];
    }
}

function formatUSD(amount: number): string {
    const format = new Intl.NumberFormat('en-US',
        {
            style: 'currency', currency: 'USD',
            minimumFractionDigits: 2
        }).format;
    return format(amount / 100);
}
