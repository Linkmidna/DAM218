package org.example;

public class HiloLector extends Thread{
    protected ArrayEnteros a;

    public HiloLector(ArrayEnteros a){
        this.a=a;
    }

    public void run(){
        while (true) {
            try {
                a.Leer();
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
