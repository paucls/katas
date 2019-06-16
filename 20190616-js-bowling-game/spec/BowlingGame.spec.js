import {Game} from "../src/BowlingGame";

describe('Bowling Game', () => {

    it('should calculate score of gutter game', () => {
        const game = new Game([0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]);

        expect(game.score()).toBe(0);
    });

    it('should calculate score with pins', () => {
        const game = new Game([1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5]);

        expect(game.score()).toBe(60);
    });

    it('should calculate score with one spare', () => {
        const game = new Game([5, 5, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5]);

        expect(game.score()).toBe(70);
    });

    it('should calculate score with all spares', () => {
        const game = new Game([5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5]);

        expect(game.score()).toBe(150);
    });

    it('should calculate score with just one strike', () => {
        const game = new Game([10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]);

        expect(game.score()).toBe(10);
    });
});