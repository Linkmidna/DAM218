package org.example;

public class Main {
    public static void main(String[] args) {
        Fichero f=new Fichero();
        FicheroHilo hilo1 = new FicheroHilo("Qujote","En un lugar de la mancha",f);
        FicheroHilo hilo2 = new FicheroHilo("Hamlet","Ser o no ser",f);

        hilo1.start();
        hilo2.start();

        try{
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}