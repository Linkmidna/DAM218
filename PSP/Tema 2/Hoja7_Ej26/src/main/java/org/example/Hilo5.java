package org.example;

import java.util.concurrent.Semaphore;

public class Hilo5 extends Thread{
    Semaphore sema;

    public Hilo5(Semaphore sema){
        this.sema=sema;
    }

    @Override
    public void run() {
        try {
            sema.acquire(6);
            System.out.println("Soy el hilo 5");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
