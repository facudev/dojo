package payments;

import steps.CheckoutStep;

public interface IAltaDeTarjeta {

    CheckoutStep escanear();

    CheckoutStep manual();
}
