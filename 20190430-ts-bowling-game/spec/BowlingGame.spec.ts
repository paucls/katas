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

    it('has as score number of pins knocked down per frame when no spares or strikes', () => {
        for (let i = 0; i < 10; i++) {
            game.roll(9);
            game.roll(0);
        }

        expect(game.score).toEqual(90)
    });

    it('has as score number of pins knocked down per frame plus spares bonuses', () => {
        for (let i = 0; i < 10; i++) {
            game.roll(5);
            game.roll(5);
        }
        game.roll(5);

        expect(game.score).toEqual(150)
    });

    it('has as score number of pins knocked down per frame plus strikes bonuses', () => {
        for (let i = 0; i < 10; i++) {
            game.roll(10);
        }
        game.roll(10);
        game.roll(10);

        expect(game.score).toEqual(300)
    });

    it('has as score number of pins knocked down per frame plus frames and strikes bonuses', () => {
        for (let i = 0; i < 8; i++) {
            game.roll(4);
            game.roll(5);
        }
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);

        expect(game.score).toEqual(132)
    });

});
