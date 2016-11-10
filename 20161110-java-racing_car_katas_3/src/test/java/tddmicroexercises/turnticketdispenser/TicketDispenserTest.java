package tddmicroexercises.turnticketdispenser;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TicketDispenserTest {

    @Test
    public void getTurnTicket_creates_a_new_ticket_with_turn_number_to_ticket() {
        TicketDispenser dispenser = new TicketDispenser();

        TurnTicket ticket = dispenser.getTurnTicket();

        assertThat(ticket, notNullValue());
        assertThat(ticket.getTurnNumber() >= 0, is(true));
    }

    @Test
    public void two_dispensers_should_dispense_different_tickets() {
        TicketDispenser dispenser1 = new TicketDispenser();
        TicketDispenser dispenser2 = new TicketDispenser();

        TurnTicket ticket1 = dispenser1.getTurnTicket();
        TurnTicket ticket2 = dispenser2.getTurnTicket();

        assertThat(ticket1.getTurnNumber(), is(not(ticket2.getTurnNumber())));
    }

}
