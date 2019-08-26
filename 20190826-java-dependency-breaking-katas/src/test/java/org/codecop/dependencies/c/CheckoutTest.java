package org.codecop.dependencies.c;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutTest {

    @Test
    public void should_create_receipt_applying_20percent_tax() {
        Checkout checkout = new Checkout() {
            @Override
            protected void storeReceipt(Receipt receipt) {
            }
        };

        Receipt receipt = checkout.createReceipt(new Money(12));

        assertEquals(
                "[Receipt, =======, Item 1 ... 12.00, Tax    ... 2.40, ----------------, Total  ... 14.40]",
                receipt.format().toString());
    }
}
