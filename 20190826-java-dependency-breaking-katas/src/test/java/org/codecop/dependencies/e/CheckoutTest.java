package org.codecop.dependencies.e;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class CheckoutTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private EmailService emailServiceMock;

    @Test(expected = OrderCancelledException.class)
    public void should_not_subscribe_user_that_do_not_accept_terms() {
        System.out.println("note for tester:");
        System.out.println("* Accept Newsletter");
        System.out.println("* Do not Accept Terms");

        Product polkaDotSocks = new Product("Polka-dot Socks");
        Checkout checkout = new Checkout(polkaDotSocks, emailServiceMock);

        checkout.confirmOrder();

        verify(emailServiceMock, never()).subscribeUserFor(any());
    }

}
