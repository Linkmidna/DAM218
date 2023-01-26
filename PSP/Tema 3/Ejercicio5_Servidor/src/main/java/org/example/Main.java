package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int numeroPuerto = 6500;
        ServerSocket servidor;

        try{

            servidor = new ServerSocket(numeroPuerto);
            Socket clienteConectado=null;
            System.out.println("Esperado a cliente...");
            clienteConectado=servidor.accept();

            clienteConectado.setSoLinger(true,10); // Esto es lo de pasar imagenes dejando abierto el socket

            InputStream entrada = clienteConectado.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);

            OutputStream salida = clienteConectado.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            String pregunta;
            System.out.println("Conexion completa, empieza:");

            FileInputStream fstream = new FileInputStream(flujoEntrada.readUTF());

            byte[] buf = new byte[1024];

            int i=0;

            while((i = fstream.read(buf)) != -1){
                flujoSalida.write(buf);
            }

            flujoSalida.writeUTF("EOF");

            System.out.println("Apagando");

            entrada.close();
            salida.close();
            servidor.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}