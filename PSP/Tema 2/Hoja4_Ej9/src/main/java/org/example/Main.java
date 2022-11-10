package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce el numero de hilos que quieras");
        int num = entrada.nextInt();

        Contador cont = new Contador();

        for (int i=0; i<num;i++){
            HiloHijo hijo = new HiloHijo(i,cont);
            hijo.start();
        }
    }
}