import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FooterTest {

    @Test
    public void obtengo_ShippingFooter_cuandoLoPido() {
        final Footer footer = new ShippingFooter(new CheckoutOptions(false));

        assertEquals(ShippingFooter.class, footer.getClass());
    }

    @Test
    public void obtengo_paymentfooter_cuandoHayCombinación() {
        final Footer footer = new PaymentFooterFactory().createPaymentFooterFactory(new CheckoutOptions(false));

        assertEquals("Falta Pagar", footer.text());
    }

    @Test
    public void obtengo_paymentfooter_cuandoEsNormal() {
        final Footer footer = new PaymentFooterFactory().createPaymentFooterFactory(new CheckoutOptions(true));


        assertEquals("Producto + Envío", footer.text());
    }

    @Test
    public void obtengo_PaymentFooter_cuandoLoPido() {
        final Footer footer = new PaymentFooter(new CheckoutOptions(false));

        assertEquals(PaymentFooter.class, footer.getClass());
    }

    @Test
    public void obtengo_InstallmentFooter_cuandoLoPido() {
        final Footer footer = new InstallmentsFooter(new CheckoutOptions(false));

        assertEquals(InstallmentsFooter.class, footer.getClass());
    }
}
