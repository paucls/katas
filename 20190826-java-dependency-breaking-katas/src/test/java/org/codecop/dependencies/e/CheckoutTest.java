package org.codecop.dependencies.e;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private EmailService emailServiceMock;

    @Mock
    private UserConfirmation subscribeToNewsLetterConfirmationMock;

    @Mock
    private UserConfirmation termsAndConditionsConfirmationMock;

    @Test(expected = OrderCancelledException.class)
    public void should_not_subscribe_user_that_want_to_subscribe_but_do_not_accept_terms() {
        Product polkaDotSocks = new Product("Polka-dot Socks");
        Checkout checkout = new Checkout(polkaDotSocks, emailServiceMock) {
            @Override
            protected UserConfirmation makeSubscribeToNewsLetterConfirmation(Product product) {
                when(subscribeToNewsLetterConfirmationMock.isAccepted()).thenReturn(true);
                return subscribeToNewsLetterConfirmationMock;
            }

            @Override
            protected UserConfirmation makeTermsAndConditionsConfirmation(Product product) {
                when(termsAndConditionsConfirmationMock.isAccepted()).thenReturn(false);
                return termsAndConditionsConfirmationMock;
            }
        };

        checkout.confirmOrder();

        verify(emailServiceMock, never()).subscribeUserFor(any());
    }

}
