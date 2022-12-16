package org.example;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(0);

        new Hilo1(s).start();
        new Hilo2(s).start();
        new Hilo3(s).start();
        new Hilo4(s).start();
        new Hilo5(s).start();
        new Hilo6(s).start();
        new Hilo7(s).start();



    }
}