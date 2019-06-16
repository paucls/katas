const NUM_FRAMES = 10;

export class Game {

    constructor(rolls) {
        this.rolls = rolls;
    }

    score() {
        let score = 0;
        let rollIndex = 0;

        for (let i = 0; i < NUM_FRAMES; i++) {
            if (this.rolls[rollIndex] + this.rolls[rollIndex + 1] === 10) {
                score += 10 + this.rolls[rollIndex + 2];
            } else {
                score += this.rolls[rollIndex] + this.rolls[rollIndex + 1];
            }
            rollIndex += 2;
        }

        return score;
    }
}