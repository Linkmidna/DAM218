package org.example;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        InetAddress dir = null;

        try {
            System.out.println("SALIDA PARA LOCALHOST: ");
            dir = InetAddress.getByName("localhost");
            pruebaMetodos(dir);

            //Para URL
            System.out.println("SALIDA PARA UNA URL");
            dir = InetAddress.getByName("www.twitch.tv");
            pruebaMetodos(dir);

            System.out.println("DIRECCIONES IP PARA: "+dir.getHostName());
            InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
            for (int i = 0; i<direcciones.length; i++){
                pruebaMetodos(direcciones[i]);
            }


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
        private static void pruebaMetodos(InetAddress dir){
            System.out.println("Metodo getByName: "+dir);
            InetAddress dir2;

            try{
                dir2 = InetAddress.getLocalHost();
                //System.out.println("Metodo getLocalHost: "+dir2);
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Metodo getHostName: "+dir.getHostName());
            System.out.println("Metodo getAddress: "+dir.getAddress());
        }
    }
