package org.example;

import java.io.*;
import java.util.Scanner;

public class Ejercicio_19 {
    public static void main(String[] args) {


        try {
            String[] commandLine = {"cmd", "/c", "codigo.bat"};
            ProcessBuilder pb = new ProcessBuilder(commandLine);
            pb.environment().put("mensaje","mundo");

            Process proceso = pb.start();


            InputStream is = proceso.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            System.out.println(br.readLine());

            br.close();
            isr.close();
            is.close();

            System.out.println("El programa ha finalizado de manera correcta.");

        } catch (IOException e) {
            System.out.println("Ha sucedido un error al ejecutar el comando. Descripcion:" + e.getMessage());
        }
    }
}