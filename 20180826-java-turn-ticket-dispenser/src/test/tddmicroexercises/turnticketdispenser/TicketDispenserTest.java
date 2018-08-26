package tddmicroexercises.turnticketdispenser;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TicketDispenserTest {

    @Test
    public void should_return_a_new_turn_ticket() {
        TicketDispenser ticketDispenser = new TicketDispenser();

        TurnTicket turnTicket = ticketDispenser.getTurnTicket();
        assertThat(turnTicket.getTurnNumber(), is(0));
    }
}