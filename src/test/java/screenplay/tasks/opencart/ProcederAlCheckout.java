package screenplay.tasks.opencart;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import screenplay.interactions.opencart.HacerClic;
import screenplay.ui.opencart.CartPageUI;
import screenplay.ui.opencart.CheckoutPageUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ProcederAlCheckout implements Task {

    public static ProcederAlCheckout comoInvitado() {
        return instrumented(ProcederAlCheckout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CartPageUI.BOTON_CHECKOUT, WebElementStateMatchers.isVisible()),
                HacerClic.en(CartPageUI.BOTON_CHECKOUT),
                WaitUntil.the(CheckoutPageUI.OPCION_GUEST_CHECKOUT, WebElementStateMatchers.isVisible()),
                HacerClic.en(CheckoutPageUI.OPCION_GUEST_CHECKOUT),
                HacerClic.en(CheckoutPageUI.BOTON_CONTINUAR_PASO1),
                WaitUntil.the(CheckoutPageUI.CAMPO_NOMBRE, WebElementStateMatchers.isVisible())
        );
    }
}
