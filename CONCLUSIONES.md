# Conclusiones de Ejecución - Reporte Serenity

**Proyecto:** EJERCICIO_1
**Aplicación bajo prueba:** OpenCart (http://opencart.abstracta.us)
**Fecha de ejecución:** 30 de marzo de 2026
**Ambiente:** Chrome / Mac OS X

---

## 1. Resumen de resultados

| Métrica | Valor |
|---|---|
| Total de escenarios | 1 |
| Total de casos de prueba | 1 |
| Pasaron | 1 (100%) |
| Fallaron | 0 |
| Pendientes / Ignorados | 0 |
| Pasos ejecutados | 9 |
| Duración total | 12s 672ms |
| Inicio | 10:17:20 |
| Fin | 10:17:32 |

**Resultado general: EXITOSO**

---

## 2. Detalle del escenario ejecutado

**Feature:** Flujo de compra de productos en OpenCart
**Escenario:** Comprar dos productos como invitado y confirmar el pedido
**Tags:** @e2e / @compra

| # | Paso | Resultado | Duración |
|---|---|---|---|
| 1 | Given que el cliente se encuentra en la página principal de OpenCart | SUCCESS | 3s 540ms |
| 2 | When agrega el primer producto "MacBook" al carrito | SUCCESS | 2s 079ms |
| 3 | And agrega el segundo producto "iPhone" al carrito | SUCCESS | 1s 579ms |
| 4 | And visualiza el carrito de compras | SUCCESS | 1s 153ms |
| 5 | And procede al checkout | SUCCESS | 1s 706ms |
| 6 | And completa el checkout como invitado con los siguientes datos | SUCCESS | 1s 359ms |
| 7 | And ingresa la dirección de envío | SUCCESS | ~1s |
| 8 | And selecciona el método de entrega | SUCCESS | ~1s |
| 9 | Then el sistema muestra el mensaje de confirmación "Your order has been placed!" | SUCCESS | ~1s |

---

## 3. Hallazgos de la ejecución

### Lo que se validó satisfactoriamente

- El motor de búsqueda de OpenCart responde correctamente al ingresar el nombre de un producto y devuelve resultados relevantes.
- El sistema permite agregar múltiples productos distintos al carrito de forma consecutiva sin conflictos.
- El flujo de checkout como invitado funciona de principio a fin sin requerir autenticación.
- El formulario de datos personales y dirección acepta correctamente todos los campos requeridos.
- El selector de país carga dinámicamente las regiones correspondientes (United States → New York), lo que indica que la dependencia entre campos funciona sin errores.
- El sistema emite correctamente la confirmación `"Your order has been placed!"` al finalizar la orden.

### Hallazgos de seguridad y calidad de la aplicación

**[HALLAZGO 1] - Certificado SSL no válido / Sitio sin HTTPS seguro**
La URL de la aplicación utiliza `http://` en lugar de `https://`, y al intentar acceder por HTTPS el certificado no es válido. Para que las pruebas automatizadas pudieran ejecutarse fue necesario configurar en `serenity.conf`:

```
webdriver.capabilities.acceptInsecureCerts = true
```

Esto indica que la aplicación **no cuenta con un certificado SSL confiable**, lo cual representa un riesgo de seguridad real para los usuarios finales, ya que los datos personales y de pago se transmiten sin cifrado verificado.

> **Severidad:** Alta — cualquier tienda de e-commerce que procese datos de usuarios debería operar sobre HTTPS con certificado válido.

---

**[HALLAZGO 2] - Campos del formulario de checkout no validan entradas vacías**
Durante la exploración del flujo de checkout se identificó que el formulario de datos del invitado **no presenta validaciones del lado cliente ni del servidor** ante el envío de campos vacíos o con datos incompletos. La aplicación no bloquea el avance ni muestra mensajes de error claros cuando se omiten campos obligatorios.

> **Severidad:** Media — la ausencia de validaciones permite que se generen órdenes con datos incompletos o incorrectos, afectando la integridad de la información y la experiencia del usuario.

---

### Observaciones de rendimiento

- El paso más lento fue la apertura de la página principal con **3s 540ms**, esperable al ser la carga inicial del navegador.
- Los pasos de interacción con formularios se mantuvieron entre **1s y 2s**, lo cual es aceptable para un ambiente web público.
- La duración total del flujo completo fue de **12s 672ms**, considerado eficiente para un escenario E2E de 9 pasos con carga de página incluida.

---

## 4. Conclusiones

- El flujo crítico de compra como invitado en OpenCart **está funcionando correctamente** en el ambiente de pruebas.
- La aplicación no presentó errores ni comportamientos inesperados durante ninguno de los 9 pasos del escenario.
- La cobertura actual representa el **happy path** del flujo de compra. No se han ejecutado escenarios negativos (datos inválidos, productos sin stock, campos vacíos), lo que representa una brecha de cobertura a considerar.
- Con un único caso de prueba automatizado se logró una tasa de éxito del **100%**, lo que valida que el ambiente y la configuración del proyecto están correctamente establecidos.
- Se recomienda ampliar la suite con escenarios de borde para aumentar la confiabilidad del reporte de calidad.
- Se identificaron **2 hallazgos de calidad** en la aplicación: ausencia de HTTPS válido y falta de validaciones en el formulario de checkout. Ambos deben ser reportados al equipo de desarrollo como defectos.
