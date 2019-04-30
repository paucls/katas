const ALL_PINS = 10;
const NUM_FRAMES = 10;

export class Game {
    private rolls: number[] = [];

    get score(): number {
        let score = 0;
        let firstInFrame = 0;

        for (let i = 0; i < NUM_FRAMES; i++) {
            if (this.isStrike(firstInFrame)) {
                score += this.calculateStrike(firstInFrame);
                firstInFrame += 1;
            } else if (this.isSpare(firstInFrame)) {
                score += this.calculateSpare(firstInFrame);
                firstInFrame += 2;
            } else {
                score += this.calculateSimple(firstInFrame);
                firstInFrame += 2;
            }
        }

        return score;
    }

    roll(pins: number) {
        this.rolls.push(pins);
    }

    private isStrike(firstInFrame: number) {
        return this.rolls[firstInFrame] == ALL_PINS;
    }

    private isSpare(firstInFrame: number) {
        return this.rolls[firstInFrame] + this.rolls[firstInFrame + 1] == ALL_PINS;
    }

    private calculateStrike(i: number) {
        return ALL_PINS + this.rolls[i + 1] + this.rolls[i + 2];
    }

    private calculateSpare(i: number) {
        return ALL_PINS + this.rolls[i + 2];
    }

    private calculateSimple(i: number) {
        return this.rolls[i] + this.rolls[i + 1];
    }
}
