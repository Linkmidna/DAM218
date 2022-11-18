package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce el numero de titulares que quieras, añadiran cada uno 100 €");
        int num = entrada.nextInt();

        CuentaBancaria cont = new CuentaBancaria();

        try {
            for (int i = 1; i <= num; i++) {
                Titular titular = new Titular("Titular " + i, cont);
                titular.start();
                titular.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}