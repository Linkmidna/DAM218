package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class Ejercicio2 {
    public static void main(String[] args) {

        try {
            File fichero = new File("futbolistas.xml");
            FileInputStream fIn = new FileInputStream(fichero);
            DataInputStream dIn = new DataInputStream(fIn);

            DocumentBuilderFactory dBFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dBFactory.newDocumentBuilder();
            //Crea un documento vacío
            //Para document tienes que importar el de org.w3c.dom
            Document doc = builder.newDocument();
            //Aqui escoges la version de xml para usar
            doc.setXmlVersion("1.0");
            //Creamos el elemento dentro del doc


            Element elementFutbolistas = doc.createElement("Futbolistas");
            //Este convertimos el elemento en el nodo raiz y ahora es inseparable de doc
            doc.appendChild(elementFutbolistas);

            while (dIn.available() != 0) {
                //Creamos un nuevo elemento
                Element elementFutbolista = doc.createElement("Futbolista");
                //Añadimos el elemento "Futbolista" al nodo "Futbolistas"
                elementFutbolistas.appendChild(elementFutbolista);
                //Creamos un nodo nuevo para el numero del futbolista
                Element elementNum = doc.createElement("num");
                //Le asignamos que sea de tipo texto y lo rellenamos
                elementNum.appendChild(doc.createTextNode(String.valueOf(dIn.readInt())));
                //Y ahora lo añadimos al nodo Futbolista
                elementFutbolista.appendChild(elementNum);
                //Añadimos otro nodo con valor para el alias del futbolista
                Element elementAlias = doc.createElement("alias");
                Text textAlias = doc.createTextNode(dIn.readUTF());
                elementAlias.appendChild(textAlias);
                elementFutbolista.appendChild(elementAlias);
                //Añadimos atributo al nodo futbolista (no es necesario añadir el alias a la vez que el atributo)
                elementFutbolista.setAttribute("equipo", dIn.readUTF());
                //Añadimos otro nodo para la posición en el campo
                Element elementPos = doc.createElement("posicion");
                elementPos.appendChild(doc.createTextNode(String.valueOf(dIn.readInt())));
                elementFutbolista.appendChild(elementPos);
                //Añadimos un ultimo nodo para la altura
                Element elementAltura = doc.createElement("altura");
                elementAltura.appendChild(doc.createTextNode(String.valueOf(dIn.readFloat())));
                elementFutbolista.appendChild(elementAltura);
            }


            //El documento está en memoria, vamos a convertirlo en XML
            Source source = new DOMSource(doc);
            //Creamos un resultado para nuestro source
            Result result = new StreamResult(new PrintWriter(new FileWriter("futbolistas.xml")));
            //Ahora toca la TransformerFactory que transformara source(doc) en el result (futbolistas.xml)
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            //Y ahora, lo transformamos
            transformer.transform(source, result);


        } catch (
                ParserConfigurationException e) {
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
