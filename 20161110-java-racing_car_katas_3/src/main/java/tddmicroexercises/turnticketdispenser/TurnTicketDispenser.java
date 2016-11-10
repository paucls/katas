package tddmicroexercises.turnticketdispenser;

public class TurnTicketDispenser {
    private TurnNumberSequence turnNumberSequence;

    public TurnTicketDispenser(TurnNumberSequence turnNumberSequence) {
        this.turnNumberSequence = turnNumberSequence;
    }

    public TurnTicket dispense() {
        return new TurnTicket(turnNumberSequence.getNextTurnNumber());
    }
}
