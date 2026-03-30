package screenplay.questions.opencart;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import screenplay.ui.opencart.CheckoutPageUI;

public class ConfirmacionDeCompra implements Question<String> {

    public static ConfirmacionDeCompra mensaje() {
        return new ConfirmacionDeCompra();
    }

    @Override
    public String answeredBy(Actor actor) {
        return CheckoutPageUI.MENSAJE_CONFIRMACION.resolveFor(actor).getText();
    }
}
