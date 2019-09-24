package org.codecop.dependencies.c;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CheckoutTest {

    @Test
    public void should_add_20_percent_vat_to_total() {
        Checkout checkout = new Checkout() {
            @Override
            protected void storeReceipt(Receipt receipt) {
            }
        };

        Receipt receipt = checkout.createReceipt(new Money(12));

        assertEquals("14.4", receipt.getTotal().toString());
    }
}
