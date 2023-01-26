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
            int numero;
            // Crea el socket
            DatagramSocket sSocket = new DatagramSocket(2000);
            // Crea el espacio para los mensajes
            byte [] cadena = new byte[1000] ;
            DatagramPacket mensaje = new DatagramPacket(cadena, cadena.length);
            System.out.println("Esperando mensajes..");

            Random ran = new Random();
            int num_secreto = ran.nextInt(100);
            System.out.println("Num secreto es :"+num_secreto);
            // Recibe y muestra el mensaje
            sSocket.receive(mensaje);
            puerto=mensaje.getPort();
            direccion=mensaje.getAddress();
            String datos;

            do{
                // Recibe y muestra el mensaje
                sSocket.receive(mensaje);
                datos=new String(mensaje.getData(),0,mensaje.getLength());
                System.out.println("\tMensaje Recibido: " +datos);
                int num = Integer.parseInt(datos);

                if (num>num_secreto){
                    datos="Te has pasado";
                }else if(num<num_secreto){
                    datos="Te has quedado corto";
                }else{
                    datos="Has acertado";
                }
                cadena=datos.getBytes();
                mensaje=new DatagramPacket(cadena,cadena.length,direccion,puerto);
                sSocket.send(mensaje);
                cadena = new byte[1000] ;
                mensaje = new DatagramPacket(cadena, cadena.length);
                System.out.println("Esperando mensajes..");


            }while(!datos.equalsIgnoreCase("Has acertado"));

            sSocket.close();

        } catch(SocketException e) {
            System.err.println("Socket: " + e.getMessage());
        } catch(IOException e) {
            System.err.println("E/S: " + e.getMessage()); }
    }
}