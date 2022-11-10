package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        File fichero= new File("NUEVODIR");
        File archivo1= new File("./NUEVODIR/archivo1.txt");
        File archivo2= new File("./NUEVODIR/archivo2.txt");
        fichero.mkdir();
        archivo1.createNewFile();
        archivo2.createNewFile();
        for (File i : fichero.listFiles() ) {
            System.out.println("Nombre: "+i.getName());
        }
        System.out.println("Introduce un nuevo nombre para el archivo 2:");
        String nombre = entrada.next();
        File nuevoarchivo2 = new File("./NUEVODIR/"+nombre);
        archivo2.renameTo(nuevoarchivo2);
        for (File i : fichero.listFiles() ) {
            System.out.println("Nombre: "+i.getName());
        }
    }
}
