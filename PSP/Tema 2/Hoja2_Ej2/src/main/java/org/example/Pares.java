package org.example;

public class Pares extends Thread{

    public void run(){
        int suma = 0;
        for (int i = 0; i<= 1000; i+=2){
            suma+=i;
        }
        System.out.println("La suma de los pares: "+suma);
    }
}
