package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String host = "localhost";
        int puerto = 6600;

        System.out.println("Programa Cliente funcionando...");
        Socket Cliente;
        try{
            Cliente = new Socket(host,puerto);
            DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());

            System.out.println("Introduce el numero:");
            int num = entrada.nextInt();
            flujoSalida.writeInt(num);

            long cuadrado = flujoEntrada.readLong();
            System.out.println("El cuadrado de "+num+" es: "+cuadrado);


            flujoEntrada.close();
            flujoSalida.close();

            Cliente.close();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}