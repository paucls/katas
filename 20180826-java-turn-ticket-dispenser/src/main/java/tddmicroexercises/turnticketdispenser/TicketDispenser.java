package tddmicroexercises.turnticketdispenser;

public class TicketDispenser {

    private TurnNumberProvider turnNumberProvider;

    public TicketDispenser() {
        this.turnNumberProvider = new TurnNumberProvider();
    }

    public TicketDispenser(TurnNumberProvider turnNumberProvider) {
        this.turnNumberProvider = turnNumberProvider;
    }

    public TurnTicket getTurnTicket() {
        int newTurnNumber = turnNumberProvider.getNextTurnNumber();
        TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);

        return newTurnTicket;
    }
}
