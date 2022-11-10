package org.example;

import java.io.File;


public class Ejercicio02 {
    public static void main(String[] args) {
        System.out.println("Introduce el nombre del directorio:");
        File fichero= new File("prueba.txt");
        System.out.println("Nombre: "+fichero.getName());
        System.out.println("Ruta: "+fichero.getPath());
        System.out.println("Ruta absoluta: "+fichero.getAbsolutePath());

        if (fichero.canRead()) System.out.println("Lectura habilitada");
        else System.out.println("Lectura deshabilitada");

        if (fichero.canWrite()) System.out.println("Escritura habilitada");
        else System.out.println("Escritura deshabilitada");
    }
}
