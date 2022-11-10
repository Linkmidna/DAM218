package org.example;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        //Document builder te permite crear constructores de parsers
        DocumentBuilderFactory dBFactory = DocumentBuilderFactory.newInstance();
        //en el try catch contruyes el parser
        try {
            DocumentBuilder builder = dBFactory.newDocumentBuilder();
            //Crea un documento vacío
            //Para document tienes que importar el de org.w3c.dom
            Document doc = builder.newDocument();
            //Aqui escoges la version de xml para usar
            doc.setXmlVersion("1.0");
            //Creamos el elemento dentro del doc
            Element elementAlumnos = doc.createElement("Alumnos");
            //Este convertimos el elemento en el nodo raiz y ahora es inseparable de doc
            doc.appendChild(elementAlumnos);
            //Añadimos atributos a ese nodo
            elementAlumnos.setAttribute("grupo", "DAM2");
            elementAlumnos.setAttribute("aula", "INF03");
            //Creamos un nuevo elemento
            Element elementAlumno = doc.createElement("Alumno");
            //Añadimos el elemento "Alumno" al nodo "Alumnos"
            elementAlumnos.appendChild(elementAlumno);
            //Creamos un nodo nuevo para el nombre del alumno
            Element elementNombre = doc.createElement("nombre");
            //Le asignamos que sea de tipo texto y lo rellenamos
            elementNombre.appendChild(doc.createTextNode("Ana Alonso"));
            //Y ahora lo añadimos al nodo alumno
            elementAlumno.appendChild(elementNombre);
            //Añadimos otro nodo con valor para la edad del alumno
            Element elementEdad = doc.createElement("Edad");
            Text textEdad = doc.createTextNode("20");
            elementEdad.appendChild(textEdad);
            elementAlumno.appendChild(elementEdad);

            //El documento está en memoria, vamos a convertirlo en XML
            Source source = new DOMSource(doc);
            //Creamos un resultado para nuestro source
            Result result = new StreamResult(new PrintWriter(new FileWriter("alumnos.xml")));
            //Ahora toca la TransformerFactory que transformara source(doc) en el result (alumnos.xml)
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            //Y ahora, lo transformamos
            transformer.transform(source,result);


        }
        catch (ParserConfigurationException e){
            System.out.println("Ha fallado la configuración del parseo.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            System.out.println("Ha fallado la configuración del transformer.");
        } catch (TransformerException e) {
            System.out.println("Ha fallado la transformación.");
        }
    }
}