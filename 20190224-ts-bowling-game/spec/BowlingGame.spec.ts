import { BowlingGame } from '../src/BowlingGame';

describe('Bowling Game', () => {

    it('should calculate score of a gutter game', () => {
        const game = new BowlingGame([0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]);

        expect(game.score).toEqual(0);
    });

    it('should calculate score when hitting pins without spares or strikes', () => {
        const game = new BowlingGame([1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5]);

        expect(game.score).toEqual(60);
    });

    it('should calculate score when getting spares', () => {
        const game = new BowlingGame([5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5]);

        expect(game.score).toEqual(150);
    });

    it('should calculate score of a perfect game where all rolls are strikes', () => {
        const game = new BowlingGame([10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10]);

        expect(game.score).toEqual(300);
    });
});
