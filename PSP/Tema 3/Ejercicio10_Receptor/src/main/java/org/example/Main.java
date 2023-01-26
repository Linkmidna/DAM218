package org.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try{
            int puerto;
            InetAddress direccion;
            String datos;
            // Crea el socket
            DatagramSocket sSocket = new DatagramSocket(3000);
            // Crea el espacio para los mensajes
            byte [] cadena = new byte[1000] ;
            DatagramPacket mensaje = new DatagramPacket(cadena, cadena.length);
            System.out.println("Esperando mensajes..");




            do{
                // Recibe y muestra el mensaje
                sSocket.receive(mensaje);
                datos=new String(mensaje.getData(),0,mensaje.getLength());
                puerto=mensaje.getPort();
                direccion=mensaje.getAddress();
                System.out.println("\tMensaje Recibido: " +datos);

                switch(datos){
                    case "como te llamas":
                        datos="Me llamo Álvaro.";
                        break;
                    case "que edad tienes":
                        datos="Tengo 28 años.";
                        break;
                    case "fin":
                        datos="Se acabó.";
                        break;
                    default :
                        datos="No he entendido la pregunta.";
                        break;
                }

                cadena=datos.getBytes();
                mensaje=new DatagramPacket(cadena,cadena.length,direccion,puerto);
                sSocket.send(mensaje);
                cadena = new byte[1000] ;
                mensaje = new DatagramPacket(cadena, cadena.length);
                System.out.println("Esperando mensajes..");


            }while(!datos.equalsIgnoreCase("Se acabó."));

            sSocket.close();

        } catch(SocketException e) {
            System.err.println("Socket: " + e.getMessage());
        } catch(IOException e) {
            System.err.println("E/S: " + e.getMessage()); }
    }
}