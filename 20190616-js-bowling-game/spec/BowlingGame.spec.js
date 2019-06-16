import {Game} from "../src/BowlingGame";
import {cases} from "jasmine-parameterized";

describe('Bowling Game', () => {

    it('should calculate score of gutter game', () => {
        const game = new Game([0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]);

        expect(game.score()).toBe(0);
    });

    it('should calculate score with pins', () => {
        const game = new Game([1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5]);

        expect(game.score()).toBe(60);
    });

    cases([
        [[5, 5, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5], 70],
        [[5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5], 150]
    ]).it('should calculate score with spares', ([rolls, score]) => {
        const game = new Game(rolls);

        expect(game.score()).toBe(score);
    });

    it('should calculate score with some strikes', () => {
        const game = new Game([10, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]);

        expect(game.score()).toBe(20);
    });

    it('should calculate score of a perfect game', () => {
        const game = new Game([10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10]);

        expect(game.score()).toBe(300);
    });
});