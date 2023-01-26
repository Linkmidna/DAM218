package org.example;

import java.io.IOException;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        try{
            int puerto;
            InetAddress direccion;

            DatagramSocket sSocket = new DatagramSocket(1234);
            byte[] cadena = new byte[1000];
            DatagramPacket mensaje = new DatagramPacket(cadena, cadena.length);
            System.out.println("Esperando mensajes");



            sSocket.receive(mensaje);
            puerto=mensaje.getPort();
            direccion = mensaje.getAddress();
            String datos = new String(mensaje.getData(),0,mensaje.getLength());
            System.out.println("\tMensaje recibido: "+datos);

            datos = "Recibido";
            cadena = datos.getBytes();
            mensaje = new DatagramPacket(cadena, cadena.length,direccion,puerto);
            sSocket.send(mensaje);

            sSocket.close();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}