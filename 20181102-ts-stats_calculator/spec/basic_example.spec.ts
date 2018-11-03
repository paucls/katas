import { cases } from 'jasmine-parameterized';

describe('Stats Calculator', () => {

    it('should determine number of elements when sequence has 0 elements', () => {
        const sequence = [];
        const statsCalculator = new StatsCalculator();
        const stats = statsCalculator.calculate(sequence);

        expect(stats.numElements).toBe(0);
    });

    it('should determine number of elements when sequence has 1 element', () => {
        const sequence = [5];
        const statsCalculator = new StatsCalculator();
        const stats = statsCalculator.calculate(sequence);

        expect(stats.numElements).toBe(1);
    });

    cases([
        [[1, 5, -2], -2],
        [[1, 5, 2], 1]
    ])
        .it('should determine min value', ([sequence, expectedMinValue]) => {
            const statsCalculator = new StatsCalculator();
            const stats = statsCalculator.calculate(sequence);

            expect(stats.minValue).toBe(expectedMinValue);
        });

});

interface SequenceStats {
    minValue: number;
    numElements: number;
}

class StatsCalculator {
    calculate(sequence: any[]): SequenceStats {
        return {
            numElements: sequence.length,
            minValue: this.calculateMinValue(sequence)
        };
    }

    private calculateMinValue(sequence: any[]) {
        return sequence.reduce((prev, curr) => curr < prev ? curr : prev, Number.MAX_VALUE);
    }
}
