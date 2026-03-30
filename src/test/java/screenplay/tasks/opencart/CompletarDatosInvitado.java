package screenplay.tasks.opencart;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import screenplay.interactions.opencart.EscribirEnCampo;
import screenplay.interactions.opencart.HacerClic;
import screenplay.interactions.opencart.SeleccionarOpcion;
import screenplay.model.GuestCustomer;
import screenplay.ui.opencart.CheckoutPageUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompletarDatosInvitado implements Task {

    private final GuestCustomer cliente;

    public CompletarDatosInvitado(GuestCustomer cliente) {
        this.cliente = cliente;
    }

    public static CompletarDatosInvitado con(GuestCustomer cliente) {
        return instrumented(CompletarDatosInvitado.class, cliente);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EscribirEnCampo.con(cliente.getNombre(), CheckoutPageUI.CAMPO_NOMBRE),
                EscribirEnCampo.con(cliente.getApellido(), CheckoutPageUI.CAMPO_APELLIDO),
                EscribirEnCampo.con(cliente.getEmail(), CheckoutPageUI.CAMPO_EMAIL),
                EscribirEnCampo.con(cliente.getTelefono(), CheckoutPageUI.CAMPO_TELEFONO),
                EscribirEnCampo.con(cliente.getDireccion1(), CheckoutPageUI.CAMPO_DIRECCION1),
                EscribirEnCampo.con(cliente.getCiudad(), CheckoutPageUI.CAMPO_CIUDAD),
                EscribirEnCampo.con(cliente.getCodigoPostal(), CheckoutPageUI.CAMPO_CODIGO_POSTAL),
                SeleccionarOpcion.con(cliente.getPais(), CheckoutPageUI.SELECTOR_PAIS),
                WaitUntil.the(CheckoutPageUI.SELECTOR_REGION, WebElementStateMatchers.isVisible()),
                SeleccionarOpcion.con(cliente.getRegion(), CheckoutPageUI.SELECTOR_REGION),
                HacerClic.en(CheckoutPageUI.BOTON_CONTINUAR_PASO2),
                WaitUntil.the(CheckoutPageUI.BOTON_CONTINUAR_DELIVERY, WebElementStateMatchers.isVisible())
        );
    }
}
