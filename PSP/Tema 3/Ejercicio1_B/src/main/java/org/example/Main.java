package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;

        System.out.println("Programa B funcionando...");
        Socket Cliente;
        String recibido;
        try{
            Cliente = new Socket(host,puerto);
            DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());

            do {
                recibido = flujoEntrada.readUTF();
                System.out.println("Recibido: "+recibido);

                if (recibido.equalsIgnoreCase("fin")){
                    flujoSalida.writeUTF("Apagate");
                    System.out.println("Enviada señal de fin");
                }else{
                    flujoSalida.writeUTF("Continua");
                    System.out.println("Enviada señal de continuar");
                }

            }while (!recibido.equalsIgnoreCase("fin"));

            Thread.sleep(1000);

            flujoEntrada.close();
            flujoSalida.close();

            Cliente.close();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}