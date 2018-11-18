import { Grid } from '../lib/grid';
import { Cell } from '../lib/cell';

describe('Grid', () => {

    it('can be created', () => {
        const cell = new Cell(0, 0);

        const grid = new Grid(2, 2, [cell, cell, cell, cell]);

        expect(grid).toBeDefined()
    });

    it('can not be created with invalid number of cells for the dimensions', () => {
        const cell = new Cell(0, 0);

        expect(() => new Grid(2, 2, [cell, cell, cell]))
            .toThrow(new Error('Invalid arguments!'));
    });

    it('should know that two cells next to each other are neighbours', () => {
        const cell1 = new Cell(0, 0);
        const cell2 = new Cell(0, 1);
        const grid = new Grid(1, 2, [cell1, cell2]);

        const neighboursCell1 = grid.neighboursOf(cell1);
        const neighboursCell2 = grid.neighboursOf(cell2);

        expect(neighboursCell1).toContain(cell2);
        expect(neighboursCell2).toContain(cell1);
    });

    it('should know that two remote cells are not neighbours', () => {
        const cell1 = new Cell(0, 0);
        const cell3 = new Cell(0, 2);
        const cell7 = new Cell(2, 0);
        const grid = new Grid(3, 3, [
            cell1, new Cell(0, 1), cell3,
            new Cell(0, 1), new Cell(1, 1), new Cell(1, 2),
            cell7, new Cell(1, 2), new Cell(2, 2)
        ]);

        const neighboursCell1 = grid.neighboursOf(cell1);
        const neighboursCell3 = grid.neighboursOf(cell3);
        const neighboursCell7 = grid.neighboursOf(cell7);

        expect(neighboursCell1).not.toContain(cell3);
        expect(neighboursCell3).not.toContain(cell1);
        expect(neighboursCell7).not.toContain(cell1);
    });

    it('should have a string representation', () => {
        const grid = new Grid(2, 3, [
            new Cell(0, 0), new Cell(0, 0, true), new Cell(0, 0),
            new Cell(0, 0), new Cell(0, 0), new Cell(0, 0)
        ]);

        const result = grid.toString();

        expect(result).toEqual('.*.\n...\n')
    });

});