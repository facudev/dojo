package steps;

import inconsistency.Inconsistencia;
import payments.Payment;
import shippings.EnvioADomicilio;

public abstract class CheckoutStep {
    private static CheckoutStep nextStep;

    public static void setNextStep(CheckoutStep step) {
        nextStep = step;
    }

    public static CheckoutStep getNextStep() {
        return nextStep;
    }

    public Review seleccionar(Payment payment) {
        return new Review();
    }

    public Inconsistencia envio(EnvioADomicilio envioADomicilio) {
        return new Inconsistencia();
    }
}
