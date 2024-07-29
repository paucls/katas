import {Fibonacci} from "@/fibonacci";

describe('Fibonacci Sequence', () => {
  const fibonacci = new Fibonacci();

  describe('first two numbers should be same as position', () => {
    test.each([
      [0, 0],
      [1, 1]
    ])('%d, %d', (position, expected) => {
      expect(fibonacci.numberAt(position)).toBe(expected);
    });
  });

  describe('other numbers are the sum of the two preceding ones', () => {
    test.each([
      [2, 1],
      [3, 2],
      [5, 5]
    ])('%d, %d', (position, expected) => {
      expect(fibonacci.numberAt(position)).toBe(expected);
    });
  });
});
