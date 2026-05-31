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
    cd ruta/a/tu/proyecto/dist
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
