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

        [Test]
        public void first_number_is_zero()
        {
            var number = fibonacciSequence.getNumberAt(0);

            Assert.That(number, Is.EqualTo(0));
        }

        [Test]
        public void second_number_is_one()
        {
            var number = fibonacciSequence.getNumberAt(1);

            Assert.That(number, Is.EqualTo(1));
        }

        [Test]
        public void third_number_is_one()
        {
            var number = fibonacciSequence.getNumberAt(2);

            Assert.That(number, Is.EqualTo(1));
        }

        [Test]
        public void fourth_number_is_two()
        {
            var number = fibonacciSequence.getNumberAt(3);

            Assert.That(number, Is.EqualTo(2));
        }

        [Test]
        public void sixth_number_is_five()
        {
            var number = fibonacciSequence.getNumberAt(5);

            Assert.That(number, Is.EqualTo(5));
        }

        [Test]
        public void validates_that_index_is_not_negative()
        {
            Assert.Throws<ArgumentException>(
                () => { fibonacciSequence.getNumberAt(-1); });
        }
    }
}