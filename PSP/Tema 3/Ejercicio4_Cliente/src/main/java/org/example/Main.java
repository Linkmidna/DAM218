package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String host = "localhost";
        int puerto = 6000;

        System.out.println("Programa Cliente funcionando...");
        Socket Cliente;
        String recibido;
        try{
            Cliente = new Socket(host,puerto);
            DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());

                System.out.println("Introduce el nombre del fichero:");
                String pregunta = entrada.nextLine();
                flujoSalida.writeUTF(pregunta);

                do {
                    recibido = flujoEntrada.readUTF();
                    System.out.println(recibido);
                }while(!recibido.equals("EOF"));

            Thread.sleep(1000);

            flujoEntrada.close();
            flujoSalida.close();

            Cliente.close();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}