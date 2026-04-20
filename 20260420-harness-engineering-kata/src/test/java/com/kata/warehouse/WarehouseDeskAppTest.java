package com.kata.warehouse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WarehouseDeskAppTest {
    private WarehouseDeskApp app;

    @BeforeEach
    void setUp() {
        app = new WarehouseDeskApp();
        app.seedData();
    }

    @Test
    void seedData_initializesStockCorrectly() {
        app.processLine("COUNT;PEN-BLACK");
        app.processLine("COUNT;PEN-BLUE");
        app.processLine("COUNT;NOTE-A5");
        app.processLine("COUNT;STAPLER");
        
        assertThat(app.getEventLog()).contains(
            "count PEN-BLACK onHand=40 reserved=0 available=40",
            "count PEN-BLUE onHand=25 reserved=0 available=25",
            "count NOTE-A5 onHand=15 reserved=0 available=15",
            "count STAPLER onHand=4 reserved=0 available=4"
        );
    }

    @Test
    void seedData_initializesPricesCorrectly() {
        assertThat(app.getPrice("PEN-BLACK")).isEqualTo(1.5);
        assertThat(app.getPrice("PEN-BLUE")).isEqualTo(1.6);
        assertThat(app.getPrice("NOTE-A5")).isEqualTo(4.0);
        assertThat(app.getPrice("STAPLER")).isEqualTo(12.0);
    }

    @Test
    void seedData_initializesCashBalance() {
        assertThat(app.getCashBalance()).isEqualTo(300.0);
    }

    @Test
    void RECV_addsStockAndDeductsCash() {
        app.processLine("RECV;NOTE-A5;5;2.20");
        
        assertThat(app.getEventLog()).contains("received 5 of NOTE-A5 at 2.2");
        assertThat(app.getCashBalance()).isEqualTo(300.0 - (5 * 2.20));
    }

    @Test
    void SELL_withAvailableStock_shipsOrder() {
        app.processLine("SELL;alice;PEN-BLACK;10");
        
        assertThat(app.getEventLog()).contains("order O1001 shipped to alice amount=15.0");
        assertThat(app.getCashBalance()).isEqualTo(300.0 + 15.0);
    }

    @Test
    void SELL_withInsufficientStock_backordersOrder() {
        app.processLine("SELL;bob;STAPLER;5");
        
        assertThat(app.getEventLog()).contains("order O1001 backordered for bob sku=STAPLER qty=5");
        assertThat(app.getCashBalance()).isEqualTo(300.0);
    }

    @Test
    void CANCEL_backorderedOrder_marksAsCancelled() {
        app.processLine("SELL;bob;STAPLER;5");
        app.processLine("CANCEL;O1001");
        
        assertThat(app.getEventLog()).contains("cancelled backorder O1001");
    }

    @Test
    void CANCEL_shippedOrder_restocksAndRefunds() {
        app.processLine("SELL;alice;PEN-BLACK;10");
        app.processLine("CANCEL;O1001");
        
        assertThat(app.getEventLog()).contains("cancelled shipped order O1001 with restock");
        assertThat(app.getCashBalance()).isEqualTo(300.0);
    }

    @Test
    void CANCEL_nonExistentOrder_logsError() {
        app.processLine("CANCEL;O9999");
        
        assertThat(app.getEventLog()).contains("cannot cancel O9999 because it does not exist");
    }

    @Test
    void COUNT_showsOnHandReservedAndAvailable() {
        app.processLine("COUNT;PEN-BLACK");
        
        assertThat(app.getEventLog()).contains("count PEN-BLACK onHand=40 reserved=0 available=40");
    }

    @Test
    void unknownCommand_logsError() {
        app.processLine("UNKNOWN;command");
        
        assertThat(app.getEventLog()).contains("unknown command: UNKNOWN;command");
    }

    @Test
    void RESERVE_withAvailableStock_createsReservation() {
        app.processLine("RESERVE;alice;PEN-BLACK;10;30");
        
        assertThat(app.getEventLog()).contains("reserved 10 of PEN-BLACK for alice as R1 expires in 30 minutes");
    }

    @Test
    void RESERVE_withInsufficientStock_fails() {
        app.processLine("RESERVE;bob;STAPLER;10;30");
        
        assertThat(app.getEventLog()).contains("cannot reserve 10 of STAPLER for bob - only 4 available");
    }

    @Test
    void RESERVE_reducesAvailableStock() {
        app.processLine("RESERVE;alice;PEN-BLACK;10;30");
        app.processLine("COUNT;PEN-BLACK");
        
        assertThat(app.getEventLog()).contains("count PEN-BLACK onHand=40 reserved=10 available=30");
    }

    @Test
    void CONFIRM_validReservation_convertsToShippedOrder() {
        app.processLine("RESERVE;alice;PEN-BLACK;10;30");
        app.processLine("CONFIRM;R1");
        
        assertThat(app.getEventLog()).contains("order O1001 shipped to alice amount=15.0 from reservation R1");
        assertThat(app.getCashBalance()).isEqualTo(315.0);
    }

    @Test
    void CONFIRM_invalidReservation_fails() {
        app.processLine("CONFIRM;R999");
        
        assertThat(app.getEventLog()).contains("cannot confirm R999 - reservation not found or expired");
    }

    @Test
    void CONFIRM_removesReservationAndRestocksAvailable() {
        app.processLine("RESERVE;alice;PEN-BLACK;10;30");
        app.processLine("CONFIRM;R1");
        app.processLine("COUNT;PEN-BLACK");
        
        assertThat(app.getEventLog()).contains("count PEN-BLACK onHand=30 reserved=0 available=30");
    }

    @Test
    void RELEASE_validReservation_returnsStockToAvailable() {
        app.processLine("RESERVE;alice;PEN-BLACK;10;30");
        app.processLine("RELEASE;R1");
        app.processLine("COUNT;PEN-BLACK");
        
        assertThat(app.getEventLog()).contains("released reservation R1 for alice - 10 of PEN-BLACK returned to available");
        assertThat(app.getEventLog()).contains("count PEN-BLACK onHand=40 reserved=0 available=40");
    }

    @Test
    void RELEASE_invalidReservation_fails() {
        app.processLine("RELEASE;R999");
        
        assertThat(app.getEventLog()).contains("cannot release R999 - reservation not found or expired");
    }

    @Test
    void expiredReservation_returnsStockToAvailable() {
        app.processLine("RESERVE;alice;PEN-BLACK;10;30");
        app.setCurrentTimeMillis(System.currentTimeMillis() + (31L * 60L * 1000L));
        app.processLine("COUNT;PEN-BLACK");
        
        assertThat(app.getEventLog()).contains("reservation R1 for alice expired - 10 of PEN-BLACK returned to available");
        assertThat(app.getEventLog()).contains("count PEN-BLACK onHand=40 reserved=0 available=40");
    }

    @Test
    void CONFIRM_onExpiredReservation_fails() {
        app.processLine("RESERVE;alice;PEN-BLACK;10;30");
        app.setCurrentTimeMillis(System.currentTimeMillis() + (31L * 60L * 1000L));
        app.processLine("CONFIRM;R1");
        
        assertThat(app.getEventLog()).contains("cannot confirm R1 - reservation not found or expired");
    }

    @Test
    void RELEASE_onExpiredReservation_fails() {
        app.processLine("RESERVE;alice;PEN-BLACK;10;30");
        app.setCurrentTimeMillis(System.currentTimeMillis() + (31L * 60L * 1000L));
        app.processLine("RELEASE;R1");
        
        assertThat(app.getEventLog()).contains("cannot release R1 - reservation not found or expired");
    }

    @Test
    void multipleReservations_trackCorrectly() {
        app.processLine("RESERVE;alice;PEN-BLACK;10;30");
        app.processLine("RESERVE;bob;PEN-BLUE;5;60");
        app.processLine("COUNT;PEN-BLACK");
        app.processLine("COUNT;PEN-BLUE");
        
        assertThat(app.getEventLog()).contains("count PEN-BLACK onHand=40 reserved=10 available=30");
        assertThat(app.getEventLog()).contains("count PEN-BLUE onHand=25 reserved=5 available=20");
    }
}
