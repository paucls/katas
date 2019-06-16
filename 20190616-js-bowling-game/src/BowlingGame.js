const NUM_FRAMES = 10;

export class Game {

    constructor(rolls) {
        this.rolls = rolls;
    }

    score() {

        let bonus = 0;
        if (this.rolls[0] + this.rolls[1] === 10) {
            bonus = this.rolls[2];

        }
        let score = 0;


        let rollIndex = 0;
        for (let i = 0; i < NUM_FRAMES; i++) {
            score += this.rolls[rollIndex] + this.rolls[rollIndex + 1];
            rollIndex += 2;
        }

        return score + bonus;
    }
}