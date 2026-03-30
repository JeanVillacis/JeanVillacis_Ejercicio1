Feature: Flujo de compra de productos en OpenCart
  Como cliente de la tienda OpenCart
  Quiero agregar productos al carrito y completar la compra como invitado
  Para recibir mi pedido sin necesidad de crear una cuenta

  Background:
    Given que el cliente se encuentra en la página principal de OpenCart

  @e2e @compra
  Scenario Outline: Comprar dos productos como invitado y confirmar el pedido
    When agrega el primer producto "<producto1>" al carrito
    And agrega el segundo producto "<producto2>" al carrito
    And visualiza el carrito de compras
    And procede al checkout
    And completa el checkout como invitado con los siguientes datos:
      | nombre   | apellido   | email   | telefono   | empresa   |
      | <nombre> | <apellido> | <email> | <telefono> | <empresa> |
    And ingresa la dirección de envío:
      | direccion1   | ciudad   | codigoPostal   | pais   | region   |
      | <direccion1> | <ciudad> | <codigoPostal> | <pais> | <region> |
    And selecciona el método de entrega
    And confirma la orden
    Then el sistema muestra el mensaje de confirmación "Your order has been placed!"

    Examples:
      | producto1 | producto2 | nombre | apellido | email                    | telefono   | empresa | direccion1      | ciudad    | codigoPostal | pais          | region   |
      | MacBook   | iPhone    | Jean   | Villacis | jean.test@automation.com | 0987654321 | QA Corp | 123 Test Street | Test City | 10001        | United States | New York |
