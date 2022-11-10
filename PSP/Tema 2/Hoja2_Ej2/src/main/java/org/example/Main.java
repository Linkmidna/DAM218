package org.example;

public class Main {
    public static void main(String[] args) {
        Pares pares = new Pares();
        Impares impares = new Impares();
        Dos_tres dt = new Dos_tres();

        pares.start();
        impares.start();
        dt.start();
    }
}