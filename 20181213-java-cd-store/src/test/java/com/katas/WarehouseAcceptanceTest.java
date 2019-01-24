package com.katas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WarehouseAcceptanceTest {

    @Test
    public void customer_can_order_title_paying_for_it() {
        // Arrange
        String title = "Metallica";
        String cardNumber = "1234";
        double total = 100.5;
        PaymentGateway paymentGateway = mock(PaymentGateway.class);
        Warehouse warehouse = new Warehouse(paymentGateway);

        // Act
        String response = warehouse.orderTitle(title, cardNumber);

        // Assert
        assertThat(response).isEqualTo("OK");
        verify(paymentGateway).processCrediCardPayment(cardNumber, total);
    }
}
