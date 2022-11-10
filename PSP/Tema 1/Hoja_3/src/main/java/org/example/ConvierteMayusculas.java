package org.example;

import java.io.*;
import java.util.Scanner;

public class ConvierteMayusculas {
    public static void main(String[] args) {
        String[] commandLine = {"cmd", "/c", "convMayus.exe"};

        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce una cadena para convertirla en mayusculas");
        String cadena = entrada.next();

        try {

            Process proceso = new ProcessBuilder(commandLine).start();

            OutputStream os = proceso.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(cadena);

            bw.close();
            osw.close();
            os.close();

            InputStream is = proceso.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            System.out.println(br.readLine());


            br.close();
            isr.close();
            is.close();
        } catch (IOException e) {
            System.out.println("Ha sucedido un error al ejecutar el comando. Descripcion:" + e.getMessage());
        }
    }
}
