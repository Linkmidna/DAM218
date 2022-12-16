package org.example;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore sema = new Semaphore(15);

        for (int i=1; i<=50 ; i++){
            new Coche ("Coche"+i,sema).start();
        }
    }
}