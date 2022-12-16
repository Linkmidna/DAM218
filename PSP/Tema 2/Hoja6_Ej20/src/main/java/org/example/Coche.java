package org.example;

import java.util.concurrent.Semaphore;

public class Coche extends Thread{
    Semaphore semaforo;
    public Coche(String nombre, Semaphore semaforo){
        this.setName(nombre);
        this.semaforo=semaforo;
    }

    public void run(){
        System.out.println(getName()+" : Está intentando entrar.");
        try {
            semaforo.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(getName()+" : Aparcado.");
        try{
            sleep((int)(Math.random()*1000));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getName()+" se ha ido del garaje.");
        semaforo.release();


    }

}
