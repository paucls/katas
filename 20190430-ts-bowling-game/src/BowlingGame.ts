const ALL_PINS = 10;
const NUM_FRAMES = 10;

export class Game {
    private rolls: number[] = [];

    get score(): number {
        let score = 0;

        for (let i = 0; i < NUM_FRAMES; i++) {
            if (this.isStrike(i)) {
                score += ALL_PINS + this.rolls[i + 1] + this.rolls[i + 2];
            } else if (this.isSpare(i)) {
                score += ALL_PINS + this.rolls[i + 2];
            } else {
                score += this.rolls[i] + this.rolls[i + 1];
            }
        }

        return score;
    }

    private isStrike(firstInFrame: number) {
        return this.rolls[firstInFrame] == ALL_PINS;
    }

    private isSpare(firstInFrame: number) {
        return this.rolls[firstInFrame] + this.rolls[firstInFrame + 1] == ALL_PINS;
    }

    roll(pins: number) {
        this.rolls.push(pins);
    }
}
