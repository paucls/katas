import { Game } from '../src/BowlingGame';

describe('Bowling Game', () => {

    const game = new Game();

    it('has score 0 when no pin knocked down', () => {
        expect(game.score).toEqual(0)
    });

    it('has as score number of pinks knocked down per roll when no spares or strikes', () => {
        for (let i = 0; i < 10; i++) {
            game.roll(9);
            game.roll(0);
        }

        expect(game.score).toEqual(90)
    });

});
