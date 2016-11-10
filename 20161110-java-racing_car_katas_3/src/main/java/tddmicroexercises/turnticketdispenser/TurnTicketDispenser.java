package tddmicroexercises.turnticketdispenser;

public class TurnTicketDispenser
{
    private TurnNumberSequence turnNumberSequence;

    public TurnTicketDispenser(TurnNumberSequence turnNumberSequence) {
        this.turnNumberSequence = turnNumberSequence;
    }

    public TurnTicket dispense()
    {
        int newTurnNumber = turnNumberSequence.getNextTurnNumber();
        TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);

        return newTurnTicket;
    }
}
