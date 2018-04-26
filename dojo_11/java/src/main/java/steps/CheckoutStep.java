package steps;

public abstract class CheckoutStep {
    private static CheckoutStep nextStep;

    public static void setNextStep(CheckoutStep step) {
        nextStep = step;
    }

    public static CheckoutStep getNextStep() {
        return nextStep;
    }
}
