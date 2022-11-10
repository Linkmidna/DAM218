package org.example;

public class HiloJoin extends Thread{
    String nombre;
    public HiloJoin(String nombre){
        this.nombre=nombre;
    }

    public void run(){
        try{
            for (int i=0; i<5 ; i++){
                System.out.println(nombre+" "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
