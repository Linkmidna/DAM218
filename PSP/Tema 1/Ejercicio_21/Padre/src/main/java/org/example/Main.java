package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            Process proceso = Runtime.getRuntime().exec("java -jar Hijo_Aleatorio.jar");
            InputStream is = proceso.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line, num = "";

            while ((line = br.readLine()) != null) {
                if (line != null) {
                    num = line;
                }
                System.out.println(line);
            }
            num += "\n";
            br.close();
            isr.close();
            proceso.waitFor();
            Process proceso2 = Runtime.getRuntime().exec("java -jar Hijo_Cuadrado.jar");
            OutputStream os = proceso2.getOutputStream();
            os.write(num.getBytes());
            os.flush();

            is = proceso2.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        }catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}