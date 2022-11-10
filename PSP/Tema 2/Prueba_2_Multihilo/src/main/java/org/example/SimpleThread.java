package org.example;

public class SimpleThread extends Thread{
    String nombre;
    public SimpleThread(String nombre){
        super(nombre);
        this.nombre=nombre;
    }
    public void run(){
        for(int i=0 ; i<10 ; i++){
            //System.out.println(i + " -> " + this.nombre);
            System.out.println(i + " -> " + this.getName());
        }
        System.out.println("Fin " + this.nombre);
    }
}
