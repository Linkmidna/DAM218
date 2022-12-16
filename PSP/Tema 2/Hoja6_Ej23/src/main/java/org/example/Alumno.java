package org.example;

import java.util.concurrent.Semaphore;

public class Alumno extends Thread{
    Bienvenida saludo;
    Semaphore sema;

    public Alumno(Bienvenida saludo, Semaphore sema){
        this.saludo=saludo;
        this.sema=sema;
    }

    @Override
    public void run() {
        System.out.println("Un alumno ha llegado");
        try{
            sema.acquire(1);
            Thread.sleep(1000);
            saludo.saludarProfesor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
