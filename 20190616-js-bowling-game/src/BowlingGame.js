export class Game {
    constructor(rolls) {
        this.rolls = rolls;
    }

    score() {
        return this.rolls.reduce((prev, roll) => prev + roll, 0);
    }
}