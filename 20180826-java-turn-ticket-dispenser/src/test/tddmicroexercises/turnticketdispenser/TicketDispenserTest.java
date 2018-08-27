package tddmicroexercises.turnticketdispenser;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TicketDispenserTest {

    private TurnNumberProvider turnNumberProviderStub = mock(TurnNumberProvider.class);

    @Test
    public void should_issue_a_new_turn_ticket() {
        TicketDispenser ticketDispenser = new TicketDispenser(turnNumberProviderStub);
        int turnNumber = 100;
        when(turnNumberProviderStub.getNextTurnNumber()).thenReturn(turnNumber);

        TurnTicket turnTicket = ticketDispenser.getTurnTicket();
        assertThat(turnTicket.getTurnNumber(), is(turnNumber));
    }

    @Test
    public void should_not_issue_same_ticket_twice() {
        TicketDispenser ticketDispenser = new TicketDispenser(turnNumberProviderStub);

        when(turnNumberProviderStub.getNextTurnNumber())
                .thenReturn(0)
                .thenReturn(1);

        TurnTicket turnTicket = ticketDispenser.getTurnTicket();
        assertThat(turnTicket.getTurnNumber(), is(0));

        turnTicket = ticketDispenser.getTurnTicket();
        assertThat(turnTicket.getTurnNumber(), is(1));
    }

    @Test
    public void should_not_issue_same_ticket_twice_from_different_dispenser() {
        TicketDispenser ticketDispenser1 = new TicketDispenser(turnNumberProviderStub);
        TicketDispenser ticketDispenser2 = new TicketDispenser(turnNumberProviderStub);

        when(turnNumberProviderStub.getNextTurnNumber())
                .thenReturn(100)
                .thenReturn(101);

        TurnTicket turnTicket = ticketDispenser1.getTurnTicket();
        assertThat(turnTicket.getTurnNumber(), is(100));

        turnTicket = ticketDispenser2.getTurnTicket();
        assertThat(turnTicket.getTurnNumber(), is(101));
    }
}