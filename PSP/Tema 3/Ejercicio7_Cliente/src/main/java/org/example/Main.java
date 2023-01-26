package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String host = "localhost";
        int puerto = 6700;

        System.out.println("Programa Cliente funcionando...");
        Socket Cliente;
        try{
            Cliente = new Socket(host,puerto);
            DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());

            System.out.println("Introduce el numero 1 :");
            int num1 = entrada.nextInt();
            flujoSalida.writeInt(num1);

            System.out.println("Introduce el numero 2 :");
            int num2 = entrada.nextInt();
            flujoSalida.writeInt(num2);

            System.out.println("Introduce el operador :");
            entrada.nextLine();
            String op = entrada.nextLine();
            flujoSalida.writeUTF(op);

            long res = flujoEntrada.readLong();
            System.out.println("El resultado es: "+res);


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