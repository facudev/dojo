package payments;

import steps.CheckoutStep;

public class ModalidadIAltaDeTarjeta extends CheckoutStep implements IAltaDeTarjeta {
    public CheckoutStep escanear() {
        return new SecurityCode();
    }

    @Override
    public CheckoutStep manual() {
        return new SecurityCode();
    }
}
