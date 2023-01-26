package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String host = "localhost";
        int puerto = 6500;

        System.out.println("Programa Cliente funcionando...");
        Socket Cliente;
        String recibido;
        try{
            Cliente = new Socket(host,puerto);
            DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());

            System.out.println("Introduce el nombre del fichero:");
            String fichero = entrada.nextLine();
            flujoSalida.writeUTF(fichero);

            FileOutputStream fw = new FileOutputStream(fichero);
            byte[] buf = new byte[1024];
            int i = 0;
            while((i=flujoEntrada.read(buf))!=-1){
                fw.write(buf,0,i);
            }


            flujoEntrada.close();
            flujoSalida.close();

            Cliente.close();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}