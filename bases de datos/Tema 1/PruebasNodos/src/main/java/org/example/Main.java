package org.example;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DocumentBuilderFactory dBFactory = DocumentBuilderFactory.newInstance();

        dBFactory.setIgnoringElementContentWhitespace(true);

        try {
            DocumentBuilder builder=dBFactory.newDocumentBuilder();
            Document doc=builder.parse("alumnos.xml");
            Element raiz = doc.getDocumentElement();

            NodeList listaAlumnos = raiz.getElementsByTagName("Alumno");

            for(int i=0 ; i< listaAlumnos.getLength(); i++){
                Element element = (Element) listaAlumnos.item(i);
                System.out.println(element.getTagName());
                String textAlumno = element.getElementsByTagName("Nombre").item(0).getTextContent();
                textAlumno = textAlumno+", "+element.getElementsByTagName("Edad").item(0).getTextContent();

                System.out.println("\t"+textAlumno);

                NodeList modulos = element.getElementsByTagName("Modulos");
                Element elementModulos=(Element) (modulos.item(0));
                NodeList listaModulos = elementModulos.getElementsByTagName("Modulo");

                for (int j = 0 ; j<listaModulos.getLength() ; j++){
                    Element elementModulo = (Element) listaModulos.item(j);

                    System.out.println("\t\t"+elementModulo.getElementsByTagName("NomModulo").item(0).getTextContent());

                    System.out.println("\tcalificación="+elementModulo.getElementsByTagName("Calificacion").item(0).getTextContent());
                }
            }


        } catch (ParserConfigurationException e) {
            System.out.println("Error al configurar el Parser.");
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (SAXException e) {
            System.out.println("SAXException");
        }

    }
}