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

        for (let i = 0; i < this.rolls.length; i++) {
            score += this.rolls[i];
        }

        return score + bonus;
    }
}