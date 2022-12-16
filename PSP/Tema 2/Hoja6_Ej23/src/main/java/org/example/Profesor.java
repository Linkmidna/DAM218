package org.example;

import java.util.concurrent.Semaphore;

public class Profesor extends Thread{
    Bienvenida saludo;
    Semaphore sema;

    public Profesor(Bienvenida saludo,Semaphore sema){
        this.saludo=saludo;
        this.sema=sema;
    }

    @Override
    public void run() {
        System.out.println("Riot Sharin ha llegado");
        try{
            sema.acquire(0);
            Thread.sleep(1000);
            saludo.llegadaProfesor();
            sema.release(15);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
