package org.example;

public class Contador{
    protected int contador=0;

    //Incrementa el valor actual del contador
    public void incContador(int val){
        this.contador=this.contador+val;
        try{
            Thread.sleep((long)(Math.random()*1000));
        }catch (InterruptedException e){
            System.out.println("Interrupcion del hilo...");
        }
        System.out.println("Valor de contador: "+contador);
    }
}

