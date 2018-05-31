package shippings;

public class EnvioADomicilio implements ShippingOption {

    private final int cost;

    public EnvioADomicilio(int cost) {
        this.cost = cost;
    }

    public boolean pagar(int minAmount, int maxAmount) {
        return false;
    }
}
