const NUM_FRAMES = 10;
const ALL_PINS = 10;

export class BowlingGame {
    constructor(private rolls: number[]) {}

    get score() {
        let result = 0;
        let firstRollInFrame = 0;

        for (let i = 0; i < NUM_FRAMES; i++) {
            if (this.isStrike(firstRollInFrame)) {
                result += this.calculateStrikeScore(firstRollInFrame);
                firstRollInFrame += 1;
            } else if (this.isSpare(firstRollInFrame)) {
                result += this.calculateSpareScore(firstRollInFrame);
                firstRollInFrame += 2;
            } else {
                result += this.calculateSimpleScore(firstRollInFrame);
                firstRollInFrame += 2;
            }
        }

        return result;
    }

    private isStrike(firstRollInFrame: number) {
        return this.rolls[firstRollInFrame] === ALL_PINS;
    }

    private isSpare(firstRollInFrame: number) {
        return this.rolls[firstRollInFrame] + this.rolls[firstRollInFrame + 1] === ALL_PINS;
    }

    private calculateStrikeScore(firstRollInFrame: number) {
        return ALL_PINS + this.rolls[firstRollInFrame + 1] + this.rolls[firstRollInFrame + 2];
    }

    private calculateSpareScore(firstRollInFrame: number) {
        return ALL_PINS + this.rolls[firstRollInFrame + 2];
    }

    private calculateSimpleScore(firstRollInFrame: number) {
        return this.rolls[firstRollInFrame] + this.rolls[firstRollInFrame + 1];
    }
}
