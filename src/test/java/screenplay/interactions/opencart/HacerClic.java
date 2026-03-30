package screenplay.interactions.opencart;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class HacerClic implements Interaction {

    private final Target objetivo;

    public HacerClic(Target objetivo) {
        this.objetivo = objetivo;
    }

    public static HacerClic en(Target objetivo) {
        return instrumented(HacerClic.class, objetivo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(objetivo)
        );
    }
}
