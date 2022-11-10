package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread[] arrayThreads = new Thread[args.length];

        for (int i=0; i< args.length; i++){
            arrayThreads[i]=new Cuenta_lineas(args[i]);
        }

        for(int i=0 ; i< args.length ; i++){
            arrayThreads[i].start();
        }

        for(int i=0 ; i< args.length ; i++){
            arrayThreads[i].join();
        }

        System.out.println("Buenas tardes.");
    }
}