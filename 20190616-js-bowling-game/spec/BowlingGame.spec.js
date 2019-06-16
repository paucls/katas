import {Game} from "../src/BowlingGame";

describe('Bowling Game', () => {

    it('should calculate score of gutter game', () => {
        var game = new Game([0, 0, 0, 0, 0, 0, 0, 0, 0, 0]);

        expect(game.score()).toBe(0);
    });

});