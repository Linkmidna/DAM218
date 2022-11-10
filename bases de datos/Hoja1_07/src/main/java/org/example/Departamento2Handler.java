package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class Departamento2Handler extends DefaultHandler {
    ArrayList<Departamento> departamentos;

    boolean esEmpleado;

    String texto;

    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    public Departamento2Handler() {
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        super.characters(chars, start, length);
        //Esto puede ser un texto de un valor de una marca
        //o incluso un espacio o un ENTER que haya entre dos marcas.
        //Solo se obtiene el texto. No puede saberse a que corresponde

        //Usamos StringBuffer para extraerlos como String del array chars
        StringBuffer buffer = new StringBuffer();
        buffer.append(chars, start, length);
        texto = buffer.toString();
    }

    @Override
    public void startElement(String uri, String localName, String nombreElem, Attributes atributos) throws SAXException {
        super.startElement(uri, localName, nombreElem, atributos);
        //Voy a evaluar todas las posibles etiquetas de inicio
        //Se evalúan las marcas que interese-
        switch (nombreElem) {

            case "departamento" -> {
                esEmpleado = false;
            }
            case "empleado" -> {
                esEmpleado = true;
            }
        }
    }
    @Override
    public void endElement(String uri, String localName, String nombreElem) throws SAXException {
        super.endElement(uri, localName, nombreElem);
        //Voy a evaluar todas las marcas de fin que necesite
        switch (nombreElem) {
            case "nombre" -> {
                //Como tanto empleado como departamento tienen nombre aquí hacemos la diferenciación
                if (esEmpleado==false){
                    //Este es para los departamentos
                }else{
                    //Este para los empleados,importante volverlo a false
                }
            }
        }
    }
}
