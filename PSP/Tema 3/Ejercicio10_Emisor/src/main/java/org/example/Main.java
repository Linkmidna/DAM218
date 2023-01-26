package org.example;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            // Crea el socket
            DatagramSocket sSocket = new DatagramSocket();
            // Construye la dirección del socket del receptor
            InetAddress maquina = InetAddress.getByName("localhost");
            int Puerto = 3000;
            Scanner teclado=new Scanner(System.in);
            String datos;

            do{
                System.out.println("Pregunta a enviar");
                datos = teclado.nextLine();
                // Crea el mensaje

                byte[] cadena = datos.getBytes();

                DatagramPacket mensaje = new DatagramPacket(cadena, datos.length(), maquina, Puerto);
                // Envía el mensaje
                sSocket.send(mensaje);
                //Recibe la respuesta
                cadena = new byte[1000];

                mensaje = new DatagramPacket(cadena, cadena.length);

                sSocket.receive(mensaje);
                datos = new String(mensaje.getData(), 0, mensaje.getLength());
                System.out.println("Mensaje del Receptor: " + datos);
            }
            while (!datos.equalsIgnoreCase("Se acabó."));
            // Cierra el socket
            sSocket.close();
        } catch (UnknownHostException e) {
            System.err.println("Desconocido: " + e.getMessage());
        } catch(SocketException e) {
            System.err.println("Socket: " + e.getMessage());
        } catch(IOException e) {
            System.err.println("E/S: " + e.getMessage());
        }
    }
}