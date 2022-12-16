package org.example;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(0);

        Hilo0 h0 = new Hilo0(s);
        Hilo1 h1 = new Hilo1(s);
        Hilo2 h2 = new Hilo2(s);
        Hilo3 h3 = new Hilo3(s);
        Hilo4 h4 = new Hilo4(s);
        Hilo5 h5 = new Hilo5(s);

        h0.start();
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
    }
}