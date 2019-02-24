export class BowlingGame {
    constructor(private rolls: number[]) {}

    get score() {
        return this.rolls.reduce((a, b) => a + b, 0);
    }
}
