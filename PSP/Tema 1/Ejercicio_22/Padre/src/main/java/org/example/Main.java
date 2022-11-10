package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Process p = new ProcessBuilder("java" , "-jar" , "hijo.jar").start();
            System.out.println("La salida del procceso hijo es: " + p.waitFor());
        }catch (IOException ex){
            System.err.println("Error de ejecución del proceso hijo");
        }catch(InterruptedException ex){
            System.err.println("Se ha interrumpido el proceso hijo");
        }

    }
}