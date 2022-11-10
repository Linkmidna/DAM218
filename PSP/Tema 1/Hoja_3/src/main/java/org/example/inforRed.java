package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class inforRed {
    public static void main(String[] args) {
        String[] commandLine = {"cmd","/c","ipconfig"};

        try{
            ProcessBuilder builder = new ProcessBuilder(commandLine);
            builder.redirectErrorStream(true);

            Process process = builder.start();

            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line;

            while((line = br.readLine())!=null){
                if (line.contains("IPv4")){
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Ha sucedido un error al ejecutar el comando. Descripcion:"+e.getMessage());
        }
    }
}
