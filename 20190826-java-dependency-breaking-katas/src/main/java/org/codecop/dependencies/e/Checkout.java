package org.codecop.dependencies.e;

public class Checkout {

    private final Product product;
    private final EmailService emailService;
    private final UserConfirmation newsLetterSubscribed;
    private final UserConfirmation termsAndConditionsAccepted;

    public Checkout(Product product, EmailService emailService) {
        this.product = product;
        this.emailService = emailService;
        this.newsLetterSubscribed = makeSubscribeToNewsLetterConfirmation(product);
        this.termsAndConditionsAccepted = makeTermsAndConditionsConfirmation(product);
    }

    public void confirmOrder() {
        if (!termsAndConditionsAccepted.isAccepted()) {
            throw new OrderCancelledException(product);
        }

        if (newsLetterSubscribed.isAccepted()) {
            emailService.subscribeUserFor(product);
        }
    }

    protected UserConfirmation makeSubscribeToNewsLetterConfirmation(Product product) {
        return new UserConfirmation("Subscribe to our product " + product.name() + " newsletter?");
    }

    protected UserConfirmation makeTermsAndConditionsConfirmation(Product product) {
        return new UserConfirmation("Accept our terms and conditions?\n" +
                "(Mandatory to place order for " + product.name() + ")");
    }
}
