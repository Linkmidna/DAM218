package org.example;

public class Contador {
    protected int contador=0;
    //Incrementar el valor actual del contador
    //Este método está sincronizado.
     public synchronized int incContador(int val){
        this.contador=this.contador+val;
        try{
            Thread.sleep((long)(Math.random()*1000));
        }catch (InterruptedException e){
            System.out.println("Interrupcion del hilo...");
        }
        return this.contador;
    }
}
