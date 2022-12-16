package org.example;

import java.util.concurrent.Semaphore;

public class Hilo4 extends Thread{
    Semaphore sema;

    public Hilo4(Semaphore sema){
        this.sema=sema;
    }

    @Override
    public void run() {
        try {
            sema.acquire(1);
            System.out.println("Soy el hilo 4");
            Thread.sleep(1000);
            sema.release(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
