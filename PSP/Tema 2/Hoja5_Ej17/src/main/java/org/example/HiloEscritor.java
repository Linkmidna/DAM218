package org.example;

public class HiloEscritor extends Thread{
    protected ArrayEnteros a;

    public HiloEscritor(ArrayEnteros a){
        this.a=a;
    }

    public void run(){
        while (true) {
            try {
                a.Escribir();
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
