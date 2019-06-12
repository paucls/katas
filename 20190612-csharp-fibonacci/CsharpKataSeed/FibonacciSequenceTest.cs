using NUnit.Framework;

namespace Tdd
{
    [TestFixture]
    public class FibonacciSequenceTest
    {
        private FibonacciSequence _fibonacciSequence = new FibonacciSequence();

        [Test]
        public void first_number_in_sequence_is_0()
        {
            Assert.That(_fibonacciSequence.numberAt(0), Is.EqualTo(0));
        }

        [Test]
        public void second_number_in_sequence_is_1()
        {
            Assert.That(_fibonacciSequence.numberAt(1), Is.EqualTo(1));
        }
    }
}