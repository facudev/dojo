import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import payments.IAltaDeTarjeta;
import payments.SecurityCode;
import steps.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the dojo.
 */
public class DojoTest {
	
	@Before
	public void setup() {

	}

	@Test
	public void cuando_EligeEnvioADomicilio_nextStepIs_SeleccionDeMedioDePago() {
	    // Con Precargadas y Dinero En Cuenta o Tarjeta Precargada
        // Paso 1 -> Selecciona Express a Domicilio
        // Paso 2 -> ¿Como quieres pagar? -> Dinero en Cuenta
        // Paso 3 -> Review -> Modificar Envio
        // Paso 4 -> Selecciona Retiro en Sucursal
        // Paso 5 -> Selecciona Sucursal
        // Paso 6 -> Review

	    // Paso 1 -> ¿Como queres recibir el producto? 00_01 -> Enviar a mi ubicacion actual
        // Paso 2 -> Envio a Villa Urquiza 01_01
        // Zeplin: https://zpl.io/25zKgWV
        SeleccionDeEnvio seleccionDeEnvio = new SeleccionDeEnvio(new SeleccionDeMedioDePago());

        CheckoutStep nextStep = seleccionDeEnvio.envioADomicilio();

        // Zeplin: https://zpl.io/br1Km7L
        Assert.assertEquals(SeleccionDeMedioDePago.class, nextStep.getClass());
	}

    @Test
    public void cuando_modificaEnvioDesdeReview_EligeEnvioADomicilio_nextStepIs_Review() {
	    // Zeplin: https://zpl.io/be48RDa
        Review review = new Review();

        SeleccionDeEnvio seleccionDeEnvio = review.modificarEnvio();

        CheckoutStep nextStep = seleccionDeEnvio.envioADomicilio(review);

        Assert.assertEquals(Review.class, nextStep.getClass());
    }

    @Test
    public void cuando_modificaEnvioDesdeReview_EligeEnvioASucursal_nextStepIs_SucursalDeCorreo() {
        // Zeplin: https://zpl.io/be48RDa
        Review review = new Review();

        SeleccionDeEnvio seleccionDeEnvio = review.modificarEnvio();

        // Zeplin: https://zpl.io/V10Ye52
        CheckoutStep nextStep = seleccionDeEnvio.retiroEnCorreo();

        Assert.assertEquals(MapaDeSucursales.class, nextStep.getClass());
    }

    @Test
    public void cuando_seleccionoEnvioADomicilio_cargoTarjetaNueva_cargoCvv_llegoAReview() {
        // Paso 1 -> Selecciona Express a Domicilio
        // Paso 2 -> ¿Como quieres pagar? -> Alta tarjeta
        // Paso 3 -> Alta número de tarjeta
        // Paso 4 -> Alta tarjeta -> ingreso cvv
        // Paso 5 -> Review
        SeleccionDeEnvio seleccionDeEnvio = new SeleccionDeEnvio();
        SeleccionDeMedioDePago seleccionDeMedioPago = seleccionDeEnvio.envioADomicilio();

        IAltaDeTarjeta altaDeTarjeta = seleccionDeMedioPago.altaTarjeta();

        SecurityCode securityCode = (SecurityCode) altaDeTarjeta.manual();

        assertEquals(Review.class, securityCode.goToReview().getClass());
    }

    @Test
    public void cuando_seleccionoEnvioADomicilio_cargoTarjetaNueva_seleccionoModalidad_cargoQR_llegoAReview() {
        SeleccionDeEnvio seleccionDeEnvio = new SeleccionDeEnvio();
        SeleccionDeMedioDePago seleccionDeMedioPago = seleccionDeEnvio.envioADomicilio();

        IAltaDeTarjeta modalidadAltaDeTarjeta = seleccionDeMedioPago.altaTarjeta();

        SecurityCode securityCode = (SecurityCode) modalidadAltaDeTarjeta.escanear();

        assertEquals(Review.class, securityCode.goToReview().getClass());
    }
}
