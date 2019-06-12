using NUnit.Framework;

namespace Tdd
{
    [TestFixture]
    public class FibonacciSequenceTest
    {
        [Test]
        public void first_number_in_sequence_is_0()
        {
            var fibonacciSequence = new FibonacciSequence();
            
            var fibonacciNumber = fibonacciSequence.numberAt(0);

            Assert.That(fibonacciNumber, Is.EqualTo(0));
        }
        
        [Test]
        public void second_number_in_sequence_is_1()
        {
            var fibonacciSequence = new FibonacciSequence();
            
            var fibonacciNumber = fibonacciSequence.numberAt(1);

            Assert.That(fibonacciNumber, Is.EqualTo(1));
        }
    }
}