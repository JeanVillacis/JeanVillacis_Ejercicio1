package screenplay.tasks.opencart;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import screenplay.interactions.opencart.EscribirEnCampo;
import screenplay.interactions.opencart.HacerClic;
import screenplay.ui.opencart.HomePageUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarProductoAlCarrito implements Task {

    private final String nombreProducto;

    public AgregarProductoAlCarrito(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public static AgregarProductoAlCarrito llamado(String nombreProducto) {
        return instrumented(AgregarProductoAlCarrito.class, nombreProducto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EscribirEnCampo.con(nombreProducto, HomePageUI.BARRA_BUSQUEDA),
                HacerClic.en(HomePageUI.BOTON_BUSCAR),
                WaitUntil.the(HomePageUI.RESULTADO_BUSQUEDA_PRIMER_ITEM, WebElementStateMatchers.isVisible()),
                HacerClic.en(HomePageUI.RESULTADO_BUSQUEDA_PRIMER_ITEM),
                WaitUntil.the(HomePageUI.BOTON_AGREGAR_AL_CARRITO, WebElementStateMatchers.isVisible()),
                HacerClic.en(HomePageUI.BOTON_AGREGAR_AL_CARRITO),
                WaitUntil.the(HomePageUI.ALERTA_EXITO, WebElementStateMatchers.isVisible())
        );
    }
}
