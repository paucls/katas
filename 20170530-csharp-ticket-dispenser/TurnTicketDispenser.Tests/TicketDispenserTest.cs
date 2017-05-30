using NUnit.Framework;
namespace TDDMicroExercises.TurnTicketDispenser.Tests
{
    [TestFixture]
    public class TicketDispenserTest
    {
        [Test]
        public void GetTurnTicket_should_return_a_new_ticket_using_unique_sequence_number() {
            TicketDispenser ticketDispenser = new TicketDispenser();

            TurnTicket ticket = ticketDispenser.GetTurnTicket();

            Assert.AreEqual(0, ticket.TurnNumber);
        }
    }
}
