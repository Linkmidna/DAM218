package org.example;

public class Tic extends Thread{
    public void run(){
        try {
            while(true){
                System.out.println("TIC");
                sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
