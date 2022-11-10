package org.example;

public class Tac extends Thread{
    public void run(){
        try {
            while(true){
                System.out.println("TAC");
                sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
