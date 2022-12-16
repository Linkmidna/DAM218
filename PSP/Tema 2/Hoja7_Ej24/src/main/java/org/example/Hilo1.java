package org.example;

import java.util.concurrent.Semaphore;

public class Hilo1 extends Thread{
    Semaphore sema;

    public Hilo1(Semaphore sema){
        this.sema=sema;
    }

    @Override
    public void run() {
        try {
            System.out.println("Soy el hilo 1");
            Thread.sleep(1000);
            sema.release(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
