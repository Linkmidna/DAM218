package org.example;

public class Servidor {
    protected int cuentas=0;

    public synchronized int nuevaCuenta(){
        cuentas++;
        try{
            Thread.sleep((long)(Math.random()*1000));
        }catch (InterruptedException e){
            System.out.println("Interrupcion del hilo...");
        }
        return this.cuentas;
    }
}
