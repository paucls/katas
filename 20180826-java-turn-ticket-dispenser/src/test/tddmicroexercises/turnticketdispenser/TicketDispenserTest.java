package tddmicroexercises.turnticketdispenser;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TicketDispenserTest {

    @Ignore
    @Test
    public void should_issue_a_new_turn_ticket() {
        TicketDispenser ticketDispenser = new TicketDispenser();

        TurnTicket turnTicket = ticketDispenser.getTurnTicket();
        assertThat(turnTicket.getTurnNumber(), is(0));
    }

    @Test
    public void should_not_issue_same_ticket_twice() {
        TicketDispenser ticketDispenser = new TicketDispenser();

        TurnTicket turnTicket = ticketDispenser.getTurnTicket();
        assertThat(turnTicket.getTurnNumber(), is(0));

        turnTicket = ticketDispenser.getTurnTicket();
        assertThat(turnTicket.getTurnNumber(), is(1));
    }
}