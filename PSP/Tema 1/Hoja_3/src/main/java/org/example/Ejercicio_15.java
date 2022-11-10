package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio_15 {
    public static void main(String[] args) {
        String[] commandLine = {"cmd","/c","echo","Hola","mundo"};
        String line;

        try{
            Process process = new ProcessBuilder(commandLine).start();

            BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while((line = bf.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ha sucedido un error al ejecutar el comando. Descripcion:"+e.getMessage());
        }
    }
}