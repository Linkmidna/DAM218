package org.example;

public class Main {
    public static void main(String[] args) {
        Contador cont = new Contador();

        try {

                AumentarContador aum = new AumentarContador("aumentar contador ", cont);
                aum.start();
                aum.join();

            DisminuirContador dec = new DisminuirContador("disminuir contador ", cont);
            dec.start();
            dec.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}