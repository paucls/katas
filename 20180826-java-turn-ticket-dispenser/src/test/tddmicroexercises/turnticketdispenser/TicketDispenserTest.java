package tddmicroexercises.turnticketdispenser;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TicketDispenserTest {

    @Test
    public void should_issue_a_new_turn_ticket() {
        TurnNumberProvider turnNumberProviderStub = mock(TurnNumberProvider.class);
        TicketDispenser ticketDispenser = new TicketDispenser(turnNumberProviderStub);
        int turnNumber = 100;
        when(turnNumberProviderStub.getNextTurnNumber()).thenReturn(turnNumber);

        TurnTicket turnTicket = ticketDispenser.getTurnTicket();
        assertThat(turnTicket.getTurnNumber(), is(turnNumber));
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