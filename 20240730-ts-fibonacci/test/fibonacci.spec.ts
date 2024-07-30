import {Fibonacci} from "@/fibonacci";

describe('Fibonacci Sequence', () => {

  const fibonacci = new Fibonacci();

  it('should have as its first number 0', () => {
    expect(fibonacci.numberAt(0)).toBe(0);
  });

  it('should have as its second number 1', () => {
    expect(fibonacci.numberAt(1)).toBe(1);
  });

  it('should have as its third number 1', () => {
    expect(fibonacci.numberAt(2)).toBe(1);
  });

  it('should have as its fourth number 2', () => {
    expect(fibonacci.numberAt(3)).toBe(2);
  });

  it('should have as its sixth number 5', () => {
    expect(fibonacci.numberAt(5)).toBe(5);
  });
});
