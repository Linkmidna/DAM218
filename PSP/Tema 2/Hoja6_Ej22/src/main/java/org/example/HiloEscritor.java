package org.example;

import java.util.concurrent.Semaphore;

public class HiloEscritor extends Thread{
    Semaphore sema;

    public HiloEscritor (String nom,Semaphore sema){
        this.sema=sema;
        this.setName(nom);
    }

    public void run(){
        try {
            sema.acquire(4);
            System.out.println(getName()+" Soy un hilo tonto que está escribiendo.");
            sleep((int)(Math.random()*1000));
            System.out.println(getName()+" He dejado de escribir.");
            sema.release(4);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
