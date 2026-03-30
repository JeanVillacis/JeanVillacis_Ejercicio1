package screenplay.tasks.opencart;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import screenplay.interactions.opencart.HacerClic;
import screenplay.ui.opencart.CartPageUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class VisualizarCarrito implements Task {

    public static VisualizarCarrito enLaTienda() {
        return instrumented(VisualizarCarrito.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CartPageUI.ENLACE_COMPRAS_TOP, WebElementStateMatchers.isClickable()),
                HacerClic.en(CartPageUI.ENLACE_COMPRAS_TOP),
                WaitUntil.the(CartPageUI.TABLA_CARRITO, WebElementStateMatchers.isVisible())
        );
    }
}
