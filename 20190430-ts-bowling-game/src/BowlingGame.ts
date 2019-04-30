export class Game {
    private rolls: number[] = [];

    get score(): number {
        let score = 0;

        for (let i = 0; i < this.rolls.length; i++) {
            score += this.rolls[i];
        }

        return score;
    }

    roll(pins: number) {
        this.rolls.push(pins);
    }
}
