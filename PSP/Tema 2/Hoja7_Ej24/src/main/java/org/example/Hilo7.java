package org.example;

import java.util.concurrent.Semaphore;

public class Hilo7 extends Thread{
    Semaphore sema;

    public Hilo7(Semaphore sema){
        this.sema=sema;
    }

    @Override
    public void run() {
        try {
            sema.acquire(5);
            System.out.println("Soy el hilo 7");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
