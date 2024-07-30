export class Fibonacci {
  numberAt(index: number): number {
    if (index < 2)
      return index;
    return this.numberAt(index - 1) + this.numberAt(index - 2);
  }
}
