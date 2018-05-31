public class PaymentFooterFactory {
    public Footer createPaymentFooterFactory(CheckoutOptions checkoutOptions) {
        if (checkoutOptions.combinationEnabled()) {
            return new CombinationPaymentFooter();
        }

        return new PaymentFooter(checkoutOptions);
    }
}
