package org.example;

public class HiloPadre {
    public static void main(String[] args) {

        HiloHijo hijo = new HiloHijo(5);
        hijo.start();
        try{
            hijo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
