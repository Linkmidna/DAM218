package org.example;

public class CuentaBancaria {
    protected double cantidad=0;
    protected String moneda="€";
    public synchronized void ingresar(double val){
        this.cantidad=this.cantidad+val;
        try{
            Thread.sleep((long)(Math.random()*1000));
        }catch (InterruptedException e){
            System.out.println("Interrupcion del hilo...");
        }
    }
    public double consultarSaldo(){
        return cantidad;
    }
}
