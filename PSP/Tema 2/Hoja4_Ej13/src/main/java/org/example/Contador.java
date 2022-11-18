package org.example;

public class Contador {
    protected int contador=0;
    //Incrementar el valor actual del contador
    //Este método está sincronizado.
    public synchronized void incContador(){
        contador++;
    }
    public synchronized void decContador(){
        contador--;
    }
    public synchronized int verContador(){
        return contador;
    }
}
