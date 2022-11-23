package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("cmd /cjava -jar Aleatorio21.jar");
        InputStream in = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line,num="";

        while((line=br.readLine())!=null){
            if (line!=null){
                num=line;
            }
            System.out.println(line);
        }
        num+="\n";
        br.close();
        in.close();
        process.waitFor();
        Process process2 = Runtime.getRuntime().exec("cmd /cjava -jar Cuadrado.jar");
        OutputStream os = process2.getOutputStream();
        os.write(num.getBytes());
        os.flush();

        in=process2.getInputStream();
        br= new BufferedReader(new InputStreamReader(in));
        while((line=br.readLine())!=null){
            System.out.println(line);
        }

    }
}