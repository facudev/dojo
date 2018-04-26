package steps;

import payments.IAltaDeTarjeta;
import payments.RiskyUser;

public class SeleccionDeMedioDePago extends CheckoutStep {


    private final RiskyUser risk;

    public SeleccionDeMedioDePago(RiskyUser riskyUser) {
        this.risk = riskyUser;
    }

    public SeleccionDeMedioDePago() {
        this.risk = new RiskyUser();
    }

    public IAltaDeTarjeta altaTarjeta() {
        return risk.nextStep();
    }


}
