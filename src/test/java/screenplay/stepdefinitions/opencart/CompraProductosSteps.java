package screenplay.stepdefinitions.opencart;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import screenplay.model.GuestCustomer;
import screenplay.questions.opencart.ConfirmacionDeCompra;
import screenplay.tasks.opencart.*;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class CompraProductosSteps {

    private static final String ACTOR_CLIENTE = "el cliente";

    @Given("que el cliente se encuentra en la página principal de OpenCart")
    public void elClienteEstaEnLaPaginaPrincipal() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(ACTOR_CLIENTE).attemptsTo(
                Open.url("http://opencart.abstracta.us/")
        );
    }

    @When("agrega el primer producto {string} al carrito")
    public void agregaElPrimerProducto(String nombreProducto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarProductoAlCarrito.llamado(nombreProducto)
        );
    }

    @And("agrega el segundo producto {string} al carrito")
    public void agregaElSegundoProducto(String nombreProducto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarProductoAlCarrito.llamado(nombreProducto)
        );
    }

    @And("visualiza el carrito de compras")
    public void visualizaElCarritoDeCompras() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VisualizarCarrito.enLaTienda()
        );
    }

    @And("procede al checkout")
    public void procedeAlCheckout() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcederAlCheckout.comoInvitado()
        );
    }

    @And("completa el checkout como invitado con los siguientes datos:")
    public void completaCheckoutComoInvitado(DataTable datosPersonales) {
        List<Map<String, String>> filas = datosPersonales.asMaps();
        Map<String, String> datos = filas.get(0);

        OnStage.theActorInTheSpotlight().remember("datosPersonales", datos);
    }

    @And("ingresa la dirección de envío:")
    public void ingresaDireccionDeEnvio(DataTable datosEnvio) {
        List<Map<String, String>> filas = datosEnvio.asMaps();
        Map<String, String> envio = filas.get(0);

        Map<String, String> personal = OnStage.theActorInTheSpotlight().recall("datosPersonales");

        GuestCustomer cliente = new GuestCustomer.Builder()
                .nombre(personal.get("nombre"))
                .apellido(personal.get("apellido"))
                .email(personal.get("email"))
                .telefono(personal.get("telefono"))
                .empresa(personal.getOrDefault("empresa", ""))
                .direccion1(envio.get("direccion1"))
                .ciudad(envio.get("ciudad"))
                .codigoPostal(envio.get("codigoPostal"))
                .pais(envio.get("pais"))
                .region(envio.get("region"))
                .build();

        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarDatosInvitado.con(cliente)
        );
    }

    @And("selecciona el método de entrega")
    public void seleccionaMetodoDeEntrega() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarMetodoDeEntrega.predeterminado()
        );
    }

    @And("confirma la orden")
    public void confirmaLaOrden() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ConfirmarOrden.enLaTienda()
        );
    }

    @Then("el sistema muestra el mensaje de confirmación {string}")
    public void elSistemaMuestraConfirmacion(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        "el mensaje de confirmación de la orden",
                        ConfirmacionDeCompra.mensaje(),
                        containsString(mensajeEsperado)
                )
        );
    }
}
