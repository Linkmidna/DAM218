package org.example;

public class Impares extends Thread{
    public void run(){
        int suma = 0;
        for (int i = 1; i<= 1000; i+=2){
            suma+=i;
        }
        System.out.println("La suma de los impares: "+suma);
    }
}
