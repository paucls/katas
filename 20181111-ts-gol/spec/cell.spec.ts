import { Cell } from '../lib/cell';

describe('Cell', () => {

    let cell: Cell;

    beforeEach(() => {
        cell = new Cell(0, 0, true);
    });

    it('should die when has less than 2 neighbours', () => {
        const neighbours = [new Cell(0, 1, true)];

        cell.tick(neighbours);

        expect(cell.isAlive).toBe(false);
    });

    it('should continue living if is alive and has two alive neighbours', () => {
        const neighbours = [new Cell(0, 1, true), new Cell(1, 0, true)];

        cell.tick(neighbours);

        expect(cell.isAlive).toBe(true);
    });

    it('should continue living if is alive and has three alive neighbours', () => {
        const neighbours = [new Cell(0, 1, true),
                            new Cell(1, 0, true),
                            new Cell(1, 1, true)];

        cell.tick(neighbours);

        expect(cell.isAlive).toBe(true);
    });

    it('should die by overpopulation if is alive and has more than 3 alive neighbours', () => {
        const cell = new Cell(1, 1, true);
        const neighbours = [new Cell(0, 0, true),
                            new Cell(0, 1, true),
                            new Cell(0, 2, true),
                            new Cell(1, 0, true)];

        cell.tick(neighbours);

        expect(cell.isAlive).toBe(false);
    });

    it('should become live if has exactly three alive neighbours', () => {
        const cell = new Cell(0, 0, false);
        const neighbours = [new Cell(0, 1, true),
                            new Cell(1, 0, true),
                            new Cell(1, 1, true)];

        cell.tick(neighbours);

        expect(cell.isAlive).toBe(true);
    });
});