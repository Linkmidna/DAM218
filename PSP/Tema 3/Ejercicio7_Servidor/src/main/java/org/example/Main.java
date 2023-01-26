package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int numeroPuerto = 6700;
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


            System.out.println("Conexion completa, empieza:");

            int num1 = flujoEntrada.readInt();
            int num2 = flujoEntrada.readInt();
            String op = flujoEntrada.readUTF();
            long res;
            switch(op){
                case "suma":
                    res=num1+num2;
                    break;
                case "resta":
                    res=num1-num2;
                    break;
                case "multiplica":
                    res=num1*num2;
                    break;
                case "divide":
                    res=num1/num2;
                    break;
                default:
                    res=0;
                    break;

            }
            flujoSalida.writeLong(res);

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