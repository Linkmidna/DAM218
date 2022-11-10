package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        try {
            Process proceso = new ProcessBuilder(args).start();
            InputStream is = proceso.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String linea;
            System.out.println("Salida del proceso"+ Arrays.toString(args));
            while((linea= br.readLine()) != null)
            {
                System.out.println(linea);
            }
        } catch (IOException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}