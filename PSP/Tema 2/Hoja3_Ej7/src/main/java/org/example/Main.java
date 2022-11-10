package org.example;

public class Main {
    public static void main(String[] args) {

        try {
            Hilo h = new Hilo();
            h.start();
            Thread.sleep(1000);
            h.pararHilo();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}