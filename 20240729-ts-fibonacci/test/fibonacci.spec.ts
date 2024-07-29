import {Fibonacci} from "@/fibonacci";

describe('Fibonacci Sequence', () => {
  const fibonacci = new Fibonacci();

  it('should have 0 as its first number', () => {
    expect(fibonacci.numberAt(0)).toBe(0);
  });

  it('should have 1 as its second number', () => {
    expect(fibonacci.numberAt(1)).toBe(1);
  });

  it('should have 1 as its third number', () => {
    expect(fibonacci.numberAt(2)).toBe(1);
  });

  it('should have 2 as its fourth number', () => {
    expect(fibonacci.numberAt(3)).toBe(2);
  });

  it('should have 5 as its sixth number', () => {
    expect(fibonacci.numberAt(5)).toBe(5);
  });
});
