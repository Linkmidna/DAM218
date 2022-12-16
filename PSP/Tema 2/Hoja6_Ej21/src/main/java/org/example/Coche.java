package org.example;

import java.util.concurrent.Semaphore;

public class Coche extends Thread{
    Semaphore semaforo;
    public Coche(String nombre, Semaphore semaforo){
        this.setName(nombre);
        this.semaforo=semaforo;
    }

    public void run(){


        peticionEntradaTunel();


    }

    private void peticionEntradaTunel(){


        try {
            semaforo.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(getName()+" está en el tunel.");

        try{
            sleep((int)(Math.random()*1000));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(getName()+" ha salido del tunel.");

        semaforo.release();
    }

}
