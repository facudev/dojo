public class CheckoutOptions {
    private final boolean isNormal;

    public CheckoutOptions(boolean isNormal) {
        this.isNormal = isNormal;
    }

    public boolean combinationEnabled() {
        return !isNormal;
    }
}
