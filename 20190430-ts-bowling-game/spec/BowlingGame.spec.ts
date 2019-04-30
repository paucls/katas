import { Game } from '../src/BowlingGame';

describe('Bowling Game', () => {

    it('has score 0 when no pin knocked down', () => {
        const game = new Game();

        expect(game.score).toEqual(0)
    });

});
