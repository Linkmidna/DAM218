package org.example;

public class Main {
    public static void main(String[] args) {
        SimpleThread hilo1 = new SimpleThread("Hilo 1");
        SimpleThread hilo2 = new SimpleThread("Hilo 2");

        hilo1.start();
        hilo2.start();

        try{
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Fin de la ejecucion");
    }
}