namespace Tdd
{
    public class FibonacciSequence
    {
        public int numberAt(int position)
        {
            if (position < 2)
                return position;
            else
                return 1;
        }
    }
}