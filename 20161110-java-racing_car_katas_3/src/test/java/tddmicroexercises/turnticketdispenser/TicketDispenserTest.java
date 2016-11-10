package tddmicroexercises.turnticketdispenser;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TicketDispenserTest {

    @Test
    public void getTurnTicket_creates_a_new_ticket_with_turn_number_to_ticket() {
        TicketDispenser dispenser = new TicketDispenser();

        TurnTicket ticket = dispenser.getTurnTicket();

        assertThat(ticket, notNullValue());
        assertThat(ticket.getTurnNumber(), is(0));
    }

}
