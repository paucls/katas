const NUM_FRAMES = 10;

export class BowlingGame {
    constructor(private rolls: number[]) {}

    get score() {
        let result = 0;
        let rollIdx = 0;

        for (let i = 0; i < NUM_FRAMES; i++) {
            result += this.rolls[rollIdx] + this.rolls[rollIdx + 1];
            rollIdx += 2;
        }

        return result;
    }
}
