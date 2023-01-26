package org.example;

import java.io.IOException;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        try{
            DatagramSocket sSocket = new DatagramSocket();

            InetAddress maquina = InetAddress.getByName("localhost");

            int puerto=1234;
            String datos = "token";
            byte [] cadena = datos.getBytes();

            DatagramPacket mensaje = new DatagramPacket(cadena,datos.length(),maquina,puerto);
            sSocket.send(mensaje);

            cadena = new byte[1000];
            mensaje = new DatagramPacket(cadena,cadena.length);

            sSocket.receive(mensaje);
            datos = new String(mensaje.getData(),0,mensaje.getLength());
            System.out.println("Mensaje del receptor: "+datos);

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