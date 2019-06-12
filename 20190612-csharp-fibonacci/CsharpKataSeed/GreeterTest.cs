using NUnit.Framework;

namespace Tdd
{
    [TestFixture]
    public class GreeterTest
    {
        [Test]
        public void should_say_hello()
        {
            // Arrange
            var greeter = new Greeter("John Doe");

            // Act
            var greeting = greeter.SayHello();

            // Assert
            Assert.That(greeting, Is.EqualTo("Hello, John Doe!"));
        }
    }
}