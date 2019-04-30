export class Game {
    private rolls: number[] = [];

    get score(): number {
        const ALL_PINS = 10;
        const NUM_FRAMES = 10;

        let score = 0;
        let rollIdx = 0;

        for (let i = 0; i < NUM_FRAMES; i++) {
            if (this.rolls[i] == ALL_PINS) {
                score += ALL_PINS + this.rolls[i + 1] + this.rolls[i + 2];
                rollIdx += 1;
            } else if (this.rolls[i] + this.rolls[i + 1] == ALL_PINS) {
                score += ALL_PINS + this.rolls[i + 2];
                rollIdx += 2;
            } else {
                score += this.rolls[i] + this.rolls[i + 1];
                rollIdx += 2;
            }
        }

        return score;
    }

    roll(pins: number) {
        this.rolls.push(pins);
    }
}
