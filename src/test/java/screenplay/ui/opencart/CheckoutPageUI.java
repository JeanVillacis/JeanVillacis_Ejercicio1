package screenplay.ui.opencart;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPageUI {
    public static final Target OPCION_GUEST_CHECKOUT = Target.the("opción Guest Checkout").locatedBy("xpath://input[@type='radio' and @value='guest']");
    public static final Target BOTON_CONTINUAR_PASO1 = Target.the("botón Continuar paso 1").locatedBy("xpath://input[@id='button-account']");
    public static final Target CAMPO_NOMBRE = Target.the("campo Nombre").locatedBy("xpath://input[@id='input-payment-firstname']");
    public static final Target CAMPO_APELLIDO = Target.the("campo Apellido").locatedBy("xpath://input[@id='input-payment-lastname']");
    public static final Target CAMPO_EMAIL = Target.the("campo Email").locatedBy("xpath://input[@id='input-payment-email']");
    public static final Target CAMPO_TELEFONO = Target.the("campo Teléfono").locatedBy("xpath://input[@id='input-payment-telephone']");
    public static final Target CAMPO_EMPRESA = Target.the("campo Empresa").locatedBy("xpath://input[@id='input-payment-company']");
    public static final Target CAMPO_DIRECCION1 = Target.the("campo Dirección 1").locatedBy("xpath://input[@id='input-payment-address-1']");
    public static final Target CAMPO_CIUDAD = Target.the("campo Ciudad").locatedBy("xpath://input[@id='input-payment-city']");
    public static final Target CAMPO_CODIGO_POSTAL = Target.the("campo Código Postal").locatedBy("xpath://input[@id='input-payment-postcode']");
    public static final Target SELECTOR_PAIS = Target.the("selector País").locatedBy("xpath://select[@id='input-payment-country']");
    public static final Target SELECTOR_REGION = Target.the("selector Región/Estado").locatedBy("xpath://select[@id='input-payment-zone']");
    public static final Target BOTON_CONTINUAR_PASO2 = Target.the("botón Continuar paso 2").locatedBy("xpath://input[@id='button-guest']");
    public static final Target BOTON_CONTINUAR_DELIVERY = Target.the("botón Continuar método de entrega").locatedBy("xpath://input[@id='button-shipping-method']");
    public static final Target CHECKBOX_TERMINOS = Target.the("checkbox Términos y Condiciones").locatedBy("xpath://input[@type='checkbox' and @name='agree']");
    public static final Target BOTON_CONTINUAR_PAGO = Target.the("botón Continuar Método de Pago").locatedBy("xpath://input[@id='button-payment-method']");
    public static final Target BOTON_CONFIRMAR_ORDEN_FINAL = Target.the("botón final Confirm Order").locatedBy("xpath://input[@id='button-confirm']");
    public static final Target MENSAJE_CONFIRMACION = Target.the("mensaje de confirmación de orden").locatedBy("xpath://div[@id='content']/h1");
    public static final Target BOTON_CONTINUAR_CONFIRMACION = Target.the("botón Continuar en confirmación").locatedBy("xpath://div[@id='content']//a[contains(@class, 'btn-primary')]");
}
