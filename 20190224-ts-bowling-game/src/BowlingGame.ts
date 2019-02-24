const NUM_FRAMES = 10;
const ALL_PINS = 10;

export class BowlingGame {
    constructor(private rolls: number[]) {}

    get score() {
        let result = 0;
        let rollIdx = 0;

        for (let i = 0; i < NUM_FRAMES; i++) {
            if (this.isStrike(rollIdx)) {
                result += this.calculateStrikeScore(rollIdx);
                rollIdx += 1;
            } else if (this.isSpare(rollIdx)) {
                result += this.calculateSpareScore(rollIdx);
                rollIdx += 2;
            } else {
                result += this.calculateSimpleScore(rollIdx);
                rollIdx += 2;
            }
        }

        return result;
    }

    private isStrike(rollIdx: number) {
        return this.rolls[rollIdx] === ALL_PINS;
    }

    private isSpare(rollIdx: number) {
        return this.rolls[rollIdx] + this.rolls[rollIdx + 1] === ALL_PINS;
    }

    private calculateStrikeScore(rollIdx: number) {
        return ALL_PINS + this.rolls[rollIdx + 1] + this.rolls[rollIdx + 2];
    }

    private calculateSpareScore(rollIdx: number) {
        return this.rolls[rollIdx] + this.rolls[rollIdx + 1] + this.rolls[rollIdx + 2];
    }

    private calculateSimpleScore(rollIdx: number) {
        return this.rolls[rollIdx] + this.rolls[rollIdx + 1];
    }
}
