export class Game {
    private rolls: number[] = [];

    get score(): number {
        let score = 0;
        let rollIdx = 0;

        for (let i = 0; i < 10; i++) {
            score += this.rolls[i] + this.rolls[i + 1];
            rollIdx += 2;
        }

        return score;
    }

    roll(pins: number) {
        this.rolls.push(pins);
    }
}
