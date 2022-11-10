package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class AlumnosHandler extends DefaultHandler {
    private ArrayList<Alumno> listaAlumnos;
    //para contener los valores de cada alumno leído
    private Alumno alumno;
    //para contar cuantos alumnos se leen
    private int numAlumnos;
    //para contener el último valor o texto que se haya leído
    private String texto;

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public AlumnosHandler(){
        listaAlumnos=new ArrayList();
        numAlumnos=0;
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        super.characters(chars, start, length);
        //Esto puede ser un texto de un valor de una marca
        //o incluso un espacio o un ENTER que haya entre dos marcas.
        //Solo se obtiene el texto. No puede saberse a que corresponde

        //Usamos StringBuffer para extraerlos como String del array chars
        StringBuffer buffer=new StringBuffer();
        buffer.append(chars,start,length);
        texto=buffer.toString();
    }


    @Override
    public void endElement(String uri, String localName, String nombreElem) throws SAXException {
        super.endElement(uri, localName, nombreElem);
        //Voy a evaluar todas las marcas de fin que necesite
        switch (nombreElem) {
            case "nombre" -> {
                System.out.println("Nombre:" + texto);
                alumno.setNombre(texto);
            }
            case "edad" -> {
                System.out.println("Edad:" + texto);
                alumno.setEdad(Integer.parseInt(texto));
            }
        }
    }


        @Override
    public void startElement(String uri, String localName, String nombreElem, Attributes atributos) throws SAXException {
        super.startElement(uri, localName, nombreElem, atributos);
        //Voy a evaluar todas las posibles etiquetas de inicio
        //Se evalúan las marcas que interese-
        switch (nombreElem) {
            case "alumnos" -> {
                //Obtengo el valor del atributo grupo a partir del parámetro
                String grupo = atributos.getValue("grupo");
                System.out.println("Alumnos del Grupo: " + grupo);
            }case "alumno" -> {
                numAlumnos++;
                System.out.println("Datos de Alumno " + numAlumnos);
                //Creo un objeto alumno, donde almacenaré el nombre
                alumno = new Alumno();
             //Como se terminó de leer los datos de un alumno, lo añado al arrayList

                listaAlumnos.add(alumno);
            }


        }
    }
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("SE HA INICIADO LA LECTURA DEL DOCUMENTO");
    }

}
