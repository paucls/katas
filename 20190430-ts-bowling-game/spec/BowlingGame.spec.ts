import { Game } from '../src/BowlingGame';

describe('Bowling Game', () => {

    let game;

    beforeEach(() => {
        game = new Game();
    });

    it('has score 0 when no pin knocked down', () => {
        for (let i = 0; i < 10; i++) {
            game.roll(0);
            game.roll(0);
        }

        expect(game.score).toEqual(0)
    });

    it('has as score number of pinks knocked down per frame when no spares or strikes', () => {
        for (let i = 0; i < 10; i++) {
            game.roll(9);
            game.roll(0);
        }

        expect(game.score).toEqual(90)
    });

    xit('has as score number of pinks knocked down per frame plus spares', () => {
        for (let i = 0; i < 10; i++) {
            game.roll(5);
            game.roll(5);
        }

        expect(game.score).toEqual(150)
    });

});
