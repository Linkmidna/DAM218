package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("No se ha enviado ninguna cadena");
                System.exit(1);
            } else {
                File fichero = new File("Cadenas.txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(fichero,true));
                for (int i = 0; i<5; i++){
                    bw.write(args[0]);
                }
                bw.close();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}