package tddmicroexercises.turnticketdispenser;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TurnTicketDispenserTest {

    TurnNumberSequence turnNumberSequenceMock;

    @Before
    public void setup() {
        turnNumberSequenceMock = Mockito.mock(TurnNumberSequence.class);
    }

    @Test
    public void getTurnTicket_creates_a_new_ticket_with_turn_number_to_ticket() {
        TurnTicketDispenser dispenser = new TurnTicketDispenser(turnNumberSequenceMock);
        Mockito.when(turnNumberSequenceMock.getNextTurnNumber()).thenReturn(2346);

        TurnTicket ticket = dispenser.dispense();

        assertThat(ticket, notNullValue());
        assertThat(ticket.getTurnNumber(), is(2346));
    }

    @Test
    public void two_dispensers_should_dispense_different_tickets() {
        TurnTicketDispenser dispenser1 = new TurnTicketDispenser(turnNumberSequenceMock);
        TurnTicketDispenser dispenser2 = new TurnTicketDispenser(turnNumberSequenceMock);

        Mockito.when(turnNumberSequenceMock.getNextTurnNumber())
                .thenReturn(1)
                .thenReturn(2);

        TurnTicket ticket1 = dispenser1.dispense();
        TurnTicket ticket2 = dispenser2.dispense();

        assertThat(ticket1.getTurnNumber(), is(not(ticket2.getTurnNumber())));
    }

}
