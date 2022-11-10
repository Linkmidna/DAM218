package org.example;

public class Hilo extends Thread{
    boolean stopHilo = false;
    public void run(){
        int veces = 1;
        while(stopHilo==false){
            System.out.println("No puedes pararme : "+veces);
            veces++;
        }
    }

    public void pararHilo(){
        stopHilo=true;
    }
}
