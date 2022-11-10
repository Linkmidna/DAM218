package org.example;

public class Main {
    public static void main(String[] args) {
        HiloJoin h1 = new HiloJoin("Hilo 1:");
        HiloJoin h2 = new HiloJoin("Hilo 2:");
        HiloJoin h3 = new HiloJoin("Hilo 3:");
        HiloJoin h4 = new HiloJoin("Hilo 4:");
        HiloJoin h5 = new HiloJoin("Hilo 5:");

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();

        try {
            h1.join();
            h2.join();
            h3.join();
            h4.join();
            h5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-Fin Main-");
    }
}