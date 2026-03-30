package screenplay.ui.opencart;

import net.serenitybdd.screenplay.targets.Target;

public class CartPageUI {
    public static final Target ICONO_CARRITO = Target.the("icono del carrito").locatedBy("xpath://div[@id='cart']/button");
    public static final Target BOTON_VER_CARRITO = Target.the("botón View Cart").locatedBy("xpath://div[@id='cart']//ul//a[contains(@href, 'cart')]");
    public static final Target ENLACE_COMPRAS_TOP = Target.the("enlace Shopping Cart en cabecera").locatedBy("xpath://a[@title='Shopping Cart']");
    public static final Target TABLA_CARRITO = Target.the("tabla del carrito").locatedBy("xpath://div[@id='content']//table[contains(@class, 'table')]");
    public static final Target PRODUCTOS_EN_CARRITO = Target.the("productos en el carrito").locatedBy("xpath://div[@id='content']//table[contains(@class, 'table')]//tbody/tr");
    public static final Target BOTON_CHECKOUT = Target.the("botón Checkout").locatedBy("xpath://a[contains(@href, 'checkout') and contains(@class, 'btn-primary')]");
    public static final Target SUBTOTAL = Target.the("subtotal del carrito").locatedBy("xpath://table[contains(@class, 'table-bordered')]//tfoot/tr[1]/td[last()]");
    public static final Target TOTAL_CARRITO = Target.the("total del carrito").locatedBy("xpath://table[contains(@class, 'table-bordered')]//tfoot/tr[last()]/td[last()]");
}
