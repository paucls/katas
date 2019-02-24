export class BowlingGame {
    constructor(private rolls: number[]) {}

    get score() {
        let result = 0;
        for (let roll of this.rolls) {
            result += roll;
        }
        return result;
    }
}
