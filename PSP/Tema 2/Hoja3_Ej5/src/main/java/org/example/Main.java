package org.example;

public class Main {
    public static void main(String[] args) {
        Hilo h=null;

        for (int i = 0 ; i<4 ; i++){
            h=new Hilo();
            h.setName("Hilo"+i);
            h.setPriority(i+1);
            h.start();

            System.out.println("Informacion del "+h.getName()+": "+h.toString());
        }
        System.out.println("4 hilos creados...");
    }
}