package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce el numero de conexiones que quieras");
        int num = entrada.nextInt();

        Servidor serv = new Servidor();

        for (int i = 1; i <= num; i++) {
            Terminal hijo = new Terminal(i, serv);
            hijo.start();
        }
    }
}