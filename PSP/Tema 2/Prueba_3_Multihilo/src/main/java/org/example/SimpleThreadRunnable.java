package org.example;

public class SimpleThreadRunnable implements Runnable{
    String nombre;
    public SimpleThreadRunnable(String nombre){
        this.nombre=nombre;
    }
    public void run(){
        for(int i=0 ; i<10 ; i++){
            System.out.println(i + " -> " + nombre);
        }
        System.out.println("Fin " + this.nombre);
    }
}
