package org.example;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        // Declarar como Source el archivo fuente XSL
        Source estilos = new StreamSource("estilo_alumnos.xsl");
        // Declarar como Source el archivo fuente de datos XML
        Source datos = new StreamSource("alumnos.xml");

        //Archivo HTML donde se guardará el resultado de la conversión
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("salida.html");
            // Construir un objeto result que grabará contenido en out
            Result result = new StreamResult(out);
            //Construimos un conversor que aplique los estilos
            Transformer transformer = TransformerFactory.newInstance().newTransformer(estilos);
            //Hacemos la conversion de alumnos.xml y obtenemos el resultado en result que se aplicará a out (a salida.html)
            transformer.transform(datos, result);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }


    }
}