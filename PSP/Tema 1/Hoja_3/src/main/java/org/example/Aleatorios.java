package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Aleatorios {
    public static void main(String[] args) {
        String [] commandLine = {"cmd", "/c","aleatorio.exe"};

        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce una cadena para ver un numero aleatorio o la palabra FIN para acabar");
        String opc = entrada.next();

        try{
            while(!opc.equalsIgnoreCase("fin")){
                Process proceso = new ProcessBuilder(commandLine).start();

                InputStream is = proceso.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                System.out.println(br.readLine());


                System.out.println("Introduce una cadena para ver un numero aleatorio o la palabra FIN para acabar");
                opc = entrada.next();

                br.close();
                isr.close();
                is.close();

            }
        } catch (IOException e) {
            System.out.println("Ha sucedido un error al ejecutar el comando. Descripcion:"+e.getMessage());
        }

    }
}
