package org.example;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce el nombre del directorio:");
        String directorio = entrada.next();
        File fichero= new File(directorio);
        for (File i : fichero.listFiles() ) {
            System.out.println("Nombre: "+i.getName()+"\nTamaño en Bytes: "+i.length()+"\n");
        }
    }
}