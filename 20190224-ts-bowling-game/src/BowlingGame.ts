const NUM_FRAMES = 10;
const ALL_PINS = 10;

export class BowlingGame {
    constructor(private rolls: number[]) {}

    get score() {
        let result = 0;

        let rollIdx = 0;
        for (let i = 0; i < NUM_FRAMES; i++) {
            if (this.rolls[rollIdx] === ALL_PINS) {
                result += ALL_PINS + this.rolls[rollIdx + 1] + this.rolls[rollIdx + 2];
                rollIdx++;
                continue;
            }

            if (this.isSpare(rollIdx)) {
                result += this.rolls[rollIdx + 2];
            }

            result += this.rolls[rollIdx] + this.rolls[rollIdx + 1];
            rollIdx += 2;
        }

        return result;
    }

    private isSpare(rollIdx: number) {
        return this.rolls[rollIdx] + this.rolls[rollIdx + 1] === ALL_PINS;
    }
}
