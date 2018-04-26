package steps;

import payments.IAltaDeTarjeta;
import payments.SecurityCode;

public class AltaDeTarjeta extends CheckoutStep implements IAltaDeTarjeta {
    @Override
    public CheckoutStep escanear() {
        return new Review();
    }

    @Override
    public SecurityCode manual() {
        return new SecurityCode();
    }
}
