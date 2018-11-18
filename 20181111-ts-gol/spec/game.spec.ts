import { Cell } from '../lib/cell';
import { Game } from '../lib/game';
import { Grid } from '../lib/grid';

describe('Game', () => {

    it('should calculate the next state of the grid on each tick', () => {
        const grid = new Grid(2, 2, [
            new Cell(0, 0, true), new Cell(0, 1, true),
            new Cell(1, 0, true), new Cell(1, 1, false)
        ]);
        const game = new Game(grid);

        game.tick();

        expect(game.grid).toEqual(new Grid(2, 2, [
            new Cell(0, 0, true), new Cell(0, 1, true),
            new Cell(1, 0, true), new Cell(1, 1, true)
        ]));
    });

});