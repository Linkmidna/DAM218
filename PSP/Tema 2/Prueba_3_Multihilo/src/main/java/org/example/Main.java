package org.example;

public class Main {
    public static void main(String[] args) {
        SimpleThreadRunnable hilo1 = new SimpleThreadRunnable("Hilo 1");
        SimpleThreadRunnable hilo2 = new SimpleThreadRunnable("Hilo 2");

        Thread h1 = new Thread(hilo1);
        Thread h2 = new Thread(hilo2);

        h1.start();
        h2.start();
    }
}