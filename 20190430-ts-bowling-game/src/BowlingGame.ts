export class Game {
    private rolls: number[] = [];

    get score(): number {
        let score = 0;
        let rollIdx = 0;

        for (let i = 0; i < 10; i++) {
            if (this.rolls[i] + this.rolls[i + 1] == 10) {
                score += 10 + this.rolls[i + 2];
            } else {
                score += this.rolls[i] + this.rolls[i + 1];
            }
            rollIdx += 2;
        }

        return score;
    }

    roll(pins: number) {
        this.rolls.push(pins);
    }
}
