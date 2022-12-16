package org.example;

import java.util.concurrent.Semaphore;

public class Hilo0 extends Thread{
    Semaphore sema;

    public Hilo0(Semaphore sema){
        this.sema=sema;
    }

    @Override
    public void run() {
        try {

            System.out.println("Soy el hilo 0");
            Thread.sleep(1000);
            sema.release(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
