export class Game {
    constructor(rolls) {
        this.rolls = rolls;
    }

    score() {
        let bonus = 0;

        if (this.rolls[0] + this.rolls[1] == 10) {
            bonus = this.rolls[2];
        }

        return this.rolls.reduce((prev, roll) => prev + roll, 0) + bonus;
    }
}