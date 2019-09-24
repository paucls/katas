package org.codecop.dependencies.c;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CheckoutTest {

    @Test
    public void test3() {
        Checkout checkout = new Checkout() {
            @Override
            protected void storeReceipt(Receipt receipt) {
            }
        };

        checkout.createReceipt(new Money(12));

        assertNotNull(checkout);
    }
}
