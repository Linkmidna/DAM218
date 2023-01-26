package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int numeroPuerto = 6000;
        ServerSocket servidor;

        try{

            servidor = new ServerSocket(numeroPuerto);
            Socket clienteConectado=null;
            System.out.println("Esperado a cliente...");
            clienteConectado=servidor.accept();

        //FLUJO ENTRADA DE CLIENTE
            InputStream entrada = null;
            entrada = clienteConectado.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);

            //EL LCIENTE ME ENVIA EL MENSAJE
            System.out.println("Recibiendo el cliente: \n\t"+flujoEntrada.readUTF());

            //CREO EL FLUJO DE SALIDA DEL CLIENTE
            OutputStream salida = null;
            salida = clienteConectado.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            //ENVIO UN SALUDO AL CLIENTE
            flujoSalida.writeUTF("Saludos al cliente del servidor");

            //CERRAR STREAMS Y SOCKETS
            entrada.close();
            salida.close();
            servidor.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}