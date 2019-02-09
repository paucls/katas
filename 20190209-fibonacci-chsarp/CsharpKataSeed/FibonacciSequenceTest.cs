using System;
using NUnit.Framework;

namespace Tdd
{
    [TestFixture]
    public class FibonacciSequenceTest
    {
        private FibonacciSequence fibonacciSequence;

        [SetUp]
        public void setup()
        {
            fibonacciSequence = new FibonacciSequence();
        }

        [TestCase(0, 0)]
        [TestCase(1, 1)]
        public void first_two_numbers_are_same_as_index(int index, int expected)
        {
            Assert.That(fibonacciSequence.getNumberAt(index), Is.EqualTo(expected));
        }

        [TestCase(2, 1)]
        [TestCase(3, 2)]
        [TestCase(5, 5)]
        public void other_numbers_are_sum_of_the_two_preceding_ones(int index, int expected)
        {
            Assert.That(fibonacciSequence.getNumberAt(index), Is.EqualTo(expected));
        }

        [Test]
        public void validates_that_index_is_not_negative()
        {
            Assert.Throws<ArgumentException>(
                () => { fibonacciSequence.getNumberAt(-1); });
        }
    }
}