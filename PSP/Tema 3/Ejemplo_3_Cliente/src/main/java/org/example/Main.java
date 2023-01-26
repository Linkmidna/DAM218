package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;

        System.out.println("Programa cliente iniciado...");
        Socket Cliente;
        try{
            Cliente = new Socket(host,puerto);
            DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());

            flujoSalida.writeUTF("Saludos al servidor desde el cliente");

            DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
            System.out.println("Recibiendo del servidor: \n\t"+flujoEntrada.readUTF());

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