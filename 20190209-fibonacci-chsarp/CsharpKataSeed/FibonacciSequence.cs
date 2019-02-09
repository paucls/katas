using System;

namespace Tdd
{
    public class FibonacciSequence
    {
        public int getNumberAt(int index)
        {
            if (index < 0)
                throw new ArgumentException();
            if (index < 2)
                return index;
            return getNumberAt(index - 1) + getNumberAt(index - 2);
        }
    }
}