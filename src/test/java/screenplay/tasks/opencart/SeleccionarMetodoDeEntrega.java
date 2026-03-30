package screenplay.tasks.opencart;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import screenplay.interactions.opencart.HacerClic;
import screenplay.ui.opencart.CheckoutPageUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarMetodoDeEntrega implements Task {

    public static SeleccionarMetodoDeEntrega predeterminado() {
        return instrumented(SeleccionarMetodoDeEntrega.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPageUI.BOTON_CONTINUAR_DELIVERY, WebElementStateMatchers.isVisible()),
                HacerClic.en(CheckoutPageUI.BOTON_CONTINUAR_DELIVERY),
                WaitUntil.the(CheckoutPageUI.CHECKBOX_TERMINOS, WebElementStateMatchers.isVisible())
        );
    }
}
