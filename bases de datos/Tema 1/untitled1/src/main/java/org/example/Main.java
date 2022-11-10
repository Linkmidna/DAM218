package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File f=new File("pom.xml");
        FileInputStream finput = null;
        try {
             finput=new FileInputStream(f);
            int leido;
            while((leido=finput.read()) != -1){
                System.out.print((char) leido);
            }

        } catch (FileNotFoundException e) {
            System.out.println("No existe el fichero.");
        } catch (IOException e) {
            System.out.println("Error de lectura.");
        }
        try {
            finput.close();
        }catch (IOException e){
            System.out.println("Error en el cierre de fichero");
        }
    }
}