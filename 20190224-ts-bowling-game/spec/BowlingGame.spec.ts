import { BowlingGame } from '../src/BowlingGame';

describe('Bowling Game', () => {

    it('should calculate score of a gutter game', () => {
        const rolls = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];

        const game = new BowlingGame(rolls);

        expect(game.score).toEqual(0);
    });

    it('should calculate score when hitting pins without spares or strikes', () => {
        const rolls = [1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5];

        const game = new BowlingGame(rolls);

        expect(game.score).toEqual(60);
    });
});
