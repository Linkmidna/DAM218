package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner entrda = new Scanner (System.in);
            System.out.println("Introduce una cadena para repetirla");
            String linea = entrda.nextLine();
            if (linea.equals("")){
                Process p = new ProcessBuilder("java" , "-jar" , "Hijo.jar").start();
                System.out.println("La salida del procceso hijo es: " + p.waitFor());
            }else{
                Process p = new ProcessBuilder("java" , "-jar" , "Hijo.jar" , linea).start();
                System.out.println("La salida del procceso hijo es: " + p.waitFor());
            }

        }catch (IOException ex){
            System.err.println("Error de ejecución del proceso hijo");
        }catch(InterruptedException ex){
            System.err.println("Se ha interrumpido el proceso hijo");
        }
    }
}