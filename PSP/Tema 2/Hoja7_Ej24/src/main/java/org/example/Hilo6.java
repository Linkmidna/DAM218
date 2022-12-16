package org.example;

import java.util.concurrent.Semaphore;

public class Hilo6 extends Thread{
    Semaphore sema;

    public Hilo6(Semaphore sema){
        this.sema=sema;
    }

    @Override
    public void run() {
        try {
            sema.acquire(5);
            System.out.println("Soy el hilo 6");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
