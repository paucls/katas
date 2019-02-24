import { BowlingGame } from '../src/BowlingGame';

describe('Bowling Game', () => {

    it('should calculate score of a gutter game', () => {
        const rolls = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];

        const game = new BowlingGame(rolls);

        expect(game.score).toEqual(0);
    });

});
