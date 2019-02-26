export function statement(invoice, plays) {
    let totalAmount = 0;
    let volumeCredits = 0;

    let result = `Statement for ${invoice.customer}\n`;

    for (let perf of invoice.performances) {
        const play = plays[perf.playID];
        let perfAmount = 0;

        switch (play.type) {
            case 'tragedy':
                perfAmount = 40000;
                if (perf.audience > 30) {
                    perfAmount += 1000 * (perf.audience - 30);
                }
                break;
            case 'comedy':
                perfAmount = 30000;
                if (perf.audience > 20) {
                    perfAmount += 10000 + 500 * (perf.audience - 20);
                }
                perfAmount += 300 * perf.audience;
                break;
            default:
                throw new Error(`unknown type: ${play.type}`);
        }

        volumeCredits += calculateVolumeCredits(perf, play);

        // print line for this order
        result += `  ${play.name}: ${formatUSD(perfAmount)} (${perf.audience} seats)\n`;
        totalAmount += perfAmount;
    }

    result += `Amount owed is ${formatUSD(totalAmount)}\n`;
    result += `You earned ${volumeCredits} credits\n`;
    return result;
}

function formatUSD(amount: number): string {
    const format = new Intl.NumberFormat('en-US',
        {
            style: 'currency', currency: 'USD',
            minimumFractionDigits: 2
        }).format;
    return format(amount / 100);
}

function calculateVolumeCredits(performance, play) {
    let credits = Math.max(performance.audience - 30, 0);
    if ('comedy' === play.type) credits += Math.floor(performance.audience / 5);
    return credits;
}
