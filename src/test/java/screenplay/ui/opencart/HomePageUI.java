package screenplay.ui.opencart;

import net.serenitybdd.screenplay.targets.Target;

public class HomePageUI {
    public static final Target BARRA_BUSQUEDA = Target.the("barra de búsqueda").locatedBy("xpath://input[@name='search']");
    public static final Target BOTON_BUSCAR = Target.the("botón buscar").locatedBy("xpath://button[contains(@class, 'btn-default') and descendant::i[contains(@class, 'fa-search')]]");
    public static final Target NOMBRE_PRODUCTO_EN_RESULTADO = Target.the("nombre del producto en resultados").locatedBy("xpath://div[contains(@class, 'product-thumb')]//h4/a[contains(@href, '{0}')]");
    public static final Target RESULTADO_BUSQUEDA_PRIMER_ITEM = Target.the("primer resultado de búsqueda").locatedBy("xpath:(//div[contains(@class, 'product-thumb')]//h4/a)[1]");
    public static final Target BOTON_AGREGAR_AL_CARRITO = Target.the("botón Add to Cart en detalle").locatedBy("xpath://button[@id='button-cart']");
    public static final Target ALERTA_EXITO = Target.the("alerta de éxito").locatedBy("xpath://div[contains(@class, 'alert-success')]");
    public static final Target ENLACE_CARRITO_EN_ALERTA = Target.the("enlace al carrito en alerta").locatedBy("xpath://div[contains(@class, 'alert-success')]//a[contains(@href, 'cart')]");
}
