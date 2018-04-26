package payments;

import steps.CheckoutStep;
import steps.Review;

public class SecurityCode extends CheckoutStep {
    public CheckoutStep goToReview() {
        return new Review();
    }
}
