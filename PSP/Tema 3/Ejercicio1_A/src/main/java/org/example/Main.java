package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numeroPuerto = 6000;
        ServerSocket servidor;

        Scanner teclado = new Scanner(System.in);

        try{

            servidor = new ServerSocket(numeroPuerto);
            Socket clienteConectado=null;
            System.out.println("Esperado a cliente...");
            clienteConectado=servidor.accept();

            InputStream entrada = null;
            entrada = clienteConectado.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);

            OutputStream salida = null;
            salida = clienteConectado.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            String continuar;
            System.out.println("Conexion completa, empieza:");
            do {
                flujoSalida.writeUTF(teclado.nextLine());

                continuar=flujoEntrada.readUTF();
                System.out.println(continuar);
            }while (!continuar.equals("Apagate"));

            System.out.println("Apagando");

            entrada.close();
            salida.close();
            servidor.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}