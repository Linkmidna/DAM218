package org.example;

import java.util.concurrent.Semaphore;

public class HiloLector extends Thread {

    Semaphore sema;

    public HiloLector (String nom,Semaphore sema){
    this.sema=sema;
    this.setName(nom);
    }

    public void run(){
        try {
            sema.acquire(1);
            System.out.println(getName()+" Soy un hilo tonto que está leyendo.");
            sleep((int)(Math.random()*1000));
            System.out.println(getName()+" He dejado de leer.");
            sema.release(1);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
