package screenplay.interactions.opencart;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EscribirEnCampo implements Interaction {

    private final String valor;
    private final Target campo;

    public EscribirEnCampo(String valor, Target campo) {
        this.valor = valor;
        this.campo = campo;
    }

    public static EscribirEnCampo con(String valor, Target campo) {
        return instrumented(EscribirEnCampo.class, valor, campo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(valor).into(campo)
        );
    }
}
