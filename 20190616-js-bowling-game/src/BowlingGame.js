const NUM_FRAMES = 10;
const ALL_PINS = 10;

export class Game {

    constructor(rolls) {
        this.rolls = rolls;
    }

    score() {
        let score = 0;
        let rollIndex = 0;

        for (let i = 0; i < NUM_FRAMES; i++) {
            if (this.isStrike(rollIndex)) {
                score += this.calculateStrikeScore(rollIndex);
                rollIndex += 1;
            } else if (this.isSpare(rollIndex)) {
                score += this.calculateSpareScore(rollIndex);
                rollIndex += 2;
            } else {
                score += this.calculateSimpleScore(rollIndex);
                rollIndex += 2;
            }
        }

        return score;
    }

    isStrike(rollIndex) {
        return this.rolls[rollIndex] === ALL_PINS;
    }

    isSpare(rollIndex) {
        return this.rolls[rollIndex] + this.rolls[rollIndex + 1] === ALL_PINS;
    }


    calculateStrikeScore(rollIndex) {
        return ALL_PINS + this.rolls[rollIndex + 1] + this.rolls[rollIndex + 2];
    }

    calculateSpareScore(rollIndex) {
        return ALL_PINS + this.rolls[rollIndex + 2];
    }

    calculateSimpleScore(rollIndex) {
        return this.rolls[rollIndex] + this.rolls[rollIndex + 1];
    }
}