package inconsistency;

import steps.CheckoutStep;
import steps.SeleccionDeMedioDePago;

public class Inconsistencia extends CheckoutStep {
    public SeleccionDeMedioDePago cambiarMedioDePago() {
        return new SeleccionDeMedioDePago();
    }
}
