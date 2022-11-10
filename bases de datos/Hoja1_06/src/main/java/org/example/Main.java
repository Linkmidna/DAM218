package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DocumentBuilderFactory dBFactory = DocumentBuilderFactory.newInstance();
        //Metemos el fichero xml que queremos leer
        File fichero = new File("futbolistas.xml");

        Scanner entrada = new Scanner(System.in);

        //DocumentBuilder builder = dBFactory.newDocumentBuilder();
        //parseamos el xml dentro del doc con builder ¡¡¡Y YA ESTA, NO HAY MAS!!!
        //Document doc = builder.parse(fichero);

        EdicionXML lec = new EdicionXML();

        lec.abrir_XML_DOM(fichero);
        int opc = 1;
        while (opc != 0) {


            System.out.println("-- Elije una opcion --");
            System.out.println("1.- Listar futbolistas");
            System.out.println("2.- Añadir futbolista");
            System.out.println("3.- Consultar futbolista por numero");
            System.out.println("4.- Modificar equipo de un futbolista");
            System.out.println("5.- Modificar altura de un futbolista");
            System.out.println("6.- Eliminar futbolista");
            System.out.println("7.- Grabar fichero");
            System.out.println("0. Salir");
            opc = entrada.nextInt();
            switch (opc) {
                case 1:
                    System.out.println(lec.recorrerDOMyMostrar());
                    break;
                case 2:
                    Futbolista fut = new Futbolista();
                    fut.cargarPorTeclado();
                    lec.addFutbolista(fut);
                    break;
                case 3:
                    System.out.println("Introduce un numero de futbolista:");
                    String futNum = entrada.next();
                    System.out.println(lec.recorrerDOMyMostrarFiltrado(futNum));
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
            }
        }

    }
}