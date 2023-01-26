package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numeroPuerto = 6000;
        ServerSocket servidor;

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

            String pregunta;
            System.out.println("Conexion completa, empieza:");

            String ruta = flujoEntrada.readUTF();

            File fichero = new File(ruta);


            if (fichero.exists()){
                BufferedReader br = new BufferedReader(new FileReader(fichero));
                String linea;
                while((linea = br.readLine())!=null){
                    flujoSalida.writeUTF(linea);
                }
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