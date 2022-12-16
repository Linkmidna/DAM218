package org.example;

import java.util.concurrent.Semaphore;

public class Hilo2 extends Thread{
    Semaphore sema;

    public Hilo2(Semaphore sema){
        this.sema=sema;
    }

    @Override
    public void run() {
        try {
            sema.acquire(1);
            System.out.println("Soy el hilo 2");
            Thread.sleep(1000);
            sema.release(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
