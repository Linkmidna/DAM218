package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedWriter fichOut = new BufferedWriter(new FileWriter("salida.txt"));
            Scanner entrada = new Scanner(System.in);
            String linea;
            do {
                System.out.println("Nueva linea (vacia para terminar): ");
                linea = entrada.nextLine();
                fichOut.write(linea);
                fichOut.newLine();
            } while (!linea.isEmpty());
            fichOut.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}