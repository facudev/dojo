package steps;

import payments.RiskyUser;

public class SeleccionDeEnvio extends CheckoutStep {

    private final RiskyUser riskyUser;

    public SeleccionDeEnvio(CheckoutStep nextStep) {
        setNextStep(nextStep);
        this.riskyUser = new RiskyUser();
    }

    public SeleccionDeEnvio() {
        this.riskyUser = new RiskyUser();
    }

    public SeleccionDeMedioDePago envioADomicilio() {
        return new SeleccionDeMedioDePago(riskyUser);
    }

    public CheckoutStep retiroEnCorreo() {
        return new MapaDeSucursales();
    }

    public CheckoutStep envioADomicilio(Review review) {
        return review;
    }
}
