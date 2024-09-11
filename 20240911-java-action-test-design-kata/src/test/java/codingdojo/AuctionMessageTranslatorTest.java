package codingdojo;

import org.junit.jupiter.api.Test;

public class AuctionMessageTranslatorTest {
    @Test
    public void notifiesAuctionClosedWhenCloseMessageReceived() {
        String message = "SOLVersion: 1.1; Event: CLOSE;";
        var listener = new AuctionEventListenerMock();
        var translator = new AuctionMessageTranslator(listener);

        translator.processMessage(message);

        listener.toHaveBeenCalled("notifyAuctionClosed");
    }

    @Test
    public void notifiesBidDetailsWhenPriceMessageReceived() {
        String message = "SOLVersion: 1.1; Event: PRICE; CurrentPrice: 192; Increment: 7; Bidder: Someone else;";
        // TODO: write a test for this message translation
    }

    private class AuctionEventListenerMock implements AuctionEventListener {
        String actualCall;

        public void notifyAuctionClosed() {
             actualCall = "notifyAuctionClosed";
        }

        public void toHaveBeenCalled(String name) {
            if (actualCall == null) {
                throw new RuntimeException("Expected " + name + " but never called");
            }
            if (!name.equals(actualCall)) {
                throw new RuntimeException("Expected " + name + " but got " + actualCall);
            }
        }
    }
}

