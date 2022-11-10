package org.example;

import static java.lang.Thread.*;
public class Main {
    public static void main(String[] args) {

        try {
            Hilo h = new Hilo();
            h.start();
            sleep(5000);
            h.pararHilo();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}