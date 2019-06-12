using NUnit.Framework;

namespace Tdd
{
    [TestFixture]
    public class FibonacciSequenceTest
    {
        [Test]
        public void first_number_in_sequence_is_0()
        {
            FibonacciSequence fibonacciSequence = new FibonacciSequence();
            
            int fibonacciNumber = fibonacciSequence.numberAt(0);

            Assert.That(fibonacciNumber, Is.EqualTo(0));
        }
    }
}