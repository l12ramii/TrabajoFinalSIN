# Guía de Compilación y Ejecución - TrabajoFinalSIN

Este documento contiene la información necesaria para compilar, ejecutar y distribuir el proyecto **TrabajoFinalSIN**.

## Requisitos Previos

* **Java Runtime Environment (JRE):** Asegúrese de tener instalada una versión compatible de Java (se recomienda la versión utilizada durante el desarrollo para evitar errores de `UnsupportedClassVersionError`).
* **Archivos del Proyecto:** El proyecto debe haber sido compilado previamente por el IDE para generar la carpeta `dist`.

## Cómo Ejecutar el Proyecto

Para ejecutar la aplicación desde la línea de comandos, siga estos pasos:

1.  Abra una terminal o consola de comandos (CMD o PowerShell).
2.  Navegue hasta la carpeta `dist` del proyecto:
    ```bash
    cd ruta/a/TrabajoFinalSIN/dist
    ```
3.  Escriba el siguiente comando:
    ```bash
    java -jar "TrabajoFinalSIN.jar"
    ```

## Estructura de Compilación (Carpeta `dist`)

Al compilar el proyecto, el IDE genera automáticamente la carpeta `dist` con la siguiente estructura:

* **`TrabajoFinalSIN.jar`**: El archivo ejecutable principal de la aplicación.
* **`lib/`**: Una carpeta que contiene todas las librerías externas (.jar) necesarias para que el proyecto funcione.
    * *Nota:* El IDE añade automáticamente estas librerías al elemento `Class-Path` del manifiesto del JAR principal.

## Distribución del Proyecto

Para distribuir esta aplicación a otros usuarios o equipos:

1.  Comprima (zip) la carpeta **`dist`** completa.
2.  **Importante:** Asegúrese de incluir la carpeta `lib` dentro del archivo comprimido, ya que el archivo `.jar` no funcionará sin sus dependencias externas.

## Notas Importantes

* **Librerías Duplicadas:** Si existen dos archivos JAR con el mismo nombre en el classpath, solo se copiará el primero a la carpeta `lib`.
* **Tipos de Archivos:** Solo se copian archivos con extensión `.jar` a la carpeta `lib`. Otros formatos de archivo o carpetas en el classpath serán ignorados.
* **Clase Principal (Main Class):** Si necesita cambiar la clase que inicia la aplicación:
    * Haga clic derecho en el proyecto en NetBeans > **Properties**.
    * Vaya a **Run** y especifique la clase en el campo **Main Class**.
    * También puede editarse manualmente en el elemento `Main-Class` del archivo `MANIFEST.MF`.

## Estructura del ptoyecto
# Proyecto

## 📁 Estructura del proyecto

```
src/
├── components/              # Componentes reutilizables de UI
│   ├── Footer.form
│   ├── Footer.java
│   ├── Header.form
│   └── Header.java
│
├── controllers/             # Lógica de control y navegación
│   └── PageController.java
│
├── images/                  # Recursos gráficos
│   ├── bandera-catalunya.png
│   ├── bandera-spain.png
│   ├── bandera-uk.png
│   ├── correcto.png
│   ├── dni-ejemplo-1.jpg
│   ├── dni-ejemplo-2.png
│   ├── nie-ejemplo-1.jpg
│   ├── policia-log-2.png
│   └── policia-logo-1.png
│
├── main/                    # Punto de entrada de la aplicación
│   ├── java/
│   │   ├── components/
│   │   ├── controllers/
│   │   ├── models/
│   │   ├── utils/
│   │   └── views/
│   ├── Main.form
│   ├── Main.java
│   └── resources/
│
├── resources/               # Internacionalización (i18n)
│   ├── Bundle_ca_ES.properties
│   ├── Bundle_en_GB.properties
│   └── Bundle_es_ES.properties
│
├── utils/                   # Clases de utilidad
│   └── Utils.java
│
└── views/                   # Vistas de la aplicación
    ├── Acceso.form / Acceso.java
    ├── Ayuda.form / Ayuda.java
    ├── Contacto.form / Contacto.java
    ├── FormDNI.form / FormDNI.java
    ├── FormDNIOlvidado.form / FormDNIOlvidado.java
    ├── FormNIE.form / FormNIE.java
    ├── Internationalization.java
    ├── Landing.form / Landing.java
    └── TuOpinion.form / TuOpinion.java
```

## 🗂️ Descripción de módulos

| Carpeta | Descripción |
|---|---|
| `components/` | Cabecera y pie de página reutilizables en todas las vistas |
| `controllers/` | Controlador principal de navegación entre páginas |
| `images/` | Banderas, logos e imágenes de ejemplo para DNI/NIE |
| `main/` | Clase principal y estructura base del proyecto |
| `resources/` | Ficheros de traducción para español, catalán e inglés |
| `utils/` | Métodos auxiliares compartidos |
| `views/` | Pantallas de la aplicación (acceso, formularios, ayuda, etc.) |

## 🌍 Idiomas soportados

| Código | Idioma |
|---|---|
| `es_ES` | Español |
| `ca_ES` | Catalán |
| `en_GB` | Inglés |
