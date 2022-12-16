package org.example;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore sema = new Semaphore(4);

        for (int i=1;i<=3;i++){
            new HiloEscritor("Escritor"+i,sema).start();
        }
        for (int i=1;i<=4;i++){
            new HiloLector("Lector"+i,sema).start();
        }
    }
}