package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int numeroPuerto = 6600;
        ServerSocket servidor;

        try{

            servidor = new ServerSocket(numeroPuerto);
            Socket clienteConectado=null;
            System.out.println("Esperado a cliente...");
            clienteConectado=servidor.accept();

            InputStream entrada = clienteConectado.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);

            OutputStream salida = clienteConectado.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            String pregunta;
            System.out.println("Conexion completa, empieza:");

            int num = flujoEntrada.readInt();
            long cuadrado = num*num;
            System.out.println("El cuadrado de "+num+" es: "+cuadrado);
            flujoSalida.writeLong(cuadrado);

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