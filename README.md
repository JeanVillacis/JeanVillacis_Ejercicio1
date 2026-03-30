# EJERCICIO_1 - Automatización con Serenity BDD + Screenplay

Proyecto de automatización de pruebas E2E para la tienda [OpenCart](http://opencart.abstracta.us) usando el patrón Screenplay.

**Autor**: Jean Pierre Villacis

## Tecnologías

- Java 17
- Serenity BDD 4.2.9
- Cucumber 7
- Selenium 4
- Gradle

## Escenario automatizado

Flujo de compra como invitado:
1. Buscar un producto
2. Agregarlo al carrito
3. Proceder al checkout como invitado
4. Completar datos de envío
5. Seleccionar método de entrega
6. Confirmar la orden

## Estructura del proyecto

```
src/test/java/screenplay/
├── interactions/   # Acciones atómicas reutilizables
├── tasks/          # Tareas de negocio
├── questions/      # Validaciones
├── ui/             # Localizadores de elementos
├── model/          # Datos de prueba
├── stepdefinitions/# Definición de pasos Cucumber
└── runner/         # Configuración del runner

src/test/resources/
├── features/       # Escenarios Gherkin
└── serenity.conf   # Configuración Serenity
```

## Requisitos previos

- Java 17 instalado
- Google Chrome instalado
- Conexión a internet (el WebDriverManager descarga el driver automáticamente)

## Pasos para ejecutar

**1. Clonar el repositorio**
```bash
git clone <url-del-repositorio>
cd SERENITY-EJERCICIO1
```

**2. Dar permisos al wrapper de Gradle** (solo la primera vez en Mac/Linux)
```bash
chmod +x gradlew
```

**3. Compilar y ejecutar las pruebas**
```bash
./gradlew clean test
```

**4. Generar el reporte Serenity**
```bash
./gradlew aggregate
```

**5. Abrir el reporte**
```bash
open build/reports/serenity/index.html
```

> También puedes ejecutar los pasos 3, 4 y 5 en un solo comando:
> ```bash
> ./gradlew clean test aggregate && open build/reports/serenity/index.html
> ```

## Capturas de pantalla

La carpeta [`screenshots/`](screenshots/) contiene las capturas tomadas automáticamente por Serenity durante la ejecución de las pruebas. Se genera una captura después de cada paso, lo que permite evidenciar el comportamiento de la aplicación sin necesidad de correr el proyecto.

Las imágenes están nombradas secuencialmente (`paso_01.png`, `paso_02.png`, ...) siguiendo el orden de ejecución del escenario.
