package org.example;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        int puerto = 6000;
        ServerSocket Servidor;

        try{
            Servidor = new ServerSocket(puerto);
            System.out.println("Esperando clientes en "+Servidor.getLocalPort());

            Socket cliente1 = Servidor.accept();
            InetAddress i = cliente1.getInetAddress();
            System.out.println("Puerto local: "+cliente1.getLocalPort());
            System.out.println("Puerto remoto: "+cliente1.getPort());
            System.out.println("Host/IP: "+cliente1.getInetAddress());
            System.out.println("Host remoto: "+i.getHostName());
            System.out.println("IP Host remoto: "+i.getHostAddress());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}