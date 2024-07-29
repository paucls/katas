export class Fibonacci {
  numberAt(position: number): number {
    if (position < 2)
      return position;
    return this.numberAt(position - 1) + this.numberAt(position - 2);
  }
}
