package payments;

import inconsistency.Inconsistencia;
import shippings.EnvioADomicilio;
import steps.CheckoutStep;
import steps.Review;

public class Payment {
    public int minAmount;
    public int maxAmount;

    public CheckoutStep pagar(Review review, Inconsistencia inconsistencia, EnvioADomicilio envioADomicilio) {
        if (envioADomicilio.pagar(minAmount, maxAmount)) {

        }
    }
}
