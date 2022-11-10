package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class printadoWriters {
    public static void main(String[] args) {
        try {
            PrintWriter fichOut = new PrintWriter(new FileWriter("salida.txt"));
            Scanner entrada = new Scanner(System.in);
            String linea;
            do {
                System.out.println("Nueva linea (vacia para terminar): ");
                linea = entrada.nextLine();
                fichOut.println(linea);
            } while (!linea.isEmpty());
            fichOut.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
