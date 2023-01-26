package org.example;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        String Host = "localhost";
        int puerto = 6000;
        Socket Cliente;

        try{
            Cliente = new Socket(Host,puerto);
            InetAddress i = Cliente.getInetAddress();
            System.out.println("Puerto local: "+Cliente.getLocalPort());
            System.out.println("Puerto remoto: "+Cliente.getPort());
            System.out.println("Host/IP: "+Cliente.getInetAddress());
            System.out.println("Host remoto: "+i.getHostName());
            System.out.println("IP Host remoto: "+i.getHostAddress());

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}