package screenplay.interactions.opencart;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarOpcion implements Interaction {

    private final String textoVisible;
    private final Target selector;

    public SeleccionarOpcion(String textoVisible, Target selector) {
        this.textoVisible = textoVisible;
        this.selector = selector;
    }

    public static SeleccionarOpcion con(String textoVisible, Target selector) {
        return instrumented(SeleccionarOpcion.class, textoVisible, selector);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(textoVisible).from(selector)
        );
    }
}
