package steps;

import inconsistency.Inconsistencia;
import payments.Oxxo;
import payments.RiskyUser;
import shippings.EnvioADomicilio;

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

    public CheckoutStep envio(Oxxo oxxo, EnvioADomicilio envioADomicilio) {
        return oxxo.pagar(new Review(), new Inconsistencia(), envioADomicilio);
    }
}
