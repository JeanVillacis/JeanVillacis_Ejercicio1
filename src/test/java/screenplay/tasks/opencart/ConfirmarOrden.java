package screenplay.tasks.opencart;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import screenplay.interactions.opencart.HacerClic;
import screenplay.ui.opencart.CheckoutPageUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConfirmarOrden implements Task {

    public static ConfirmarOrden enLaTienda() {
        return instrumented(ConfirmarOrden.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPageUI.CHECKBOX_TERMINOS, WebElementStateMatchers.isVisible()),
                HacerClic.en(CheckoutPageUI.CHECKBOX_TERMINOS),
                HacerClic.en(CheckoutPageUI.BOTON_CONTINUAR_PAGO),
                WaitUntil.the(CheckoutPageUI.BOTON_CONFIRMAR_ORDEN_FINAL, WebElementStateMatchers.isVisible()),
                HacerClic.en(CheckoutPageUI.BOTON_CONFIRMAR_ORDEN_FINAL),
                WaitUntil.the(CheckoutPageUI.MENSAJE_CONFIRMACION, WebElementStateMatchers.containsText("Your order has been placed!"))
        );
    }
}
