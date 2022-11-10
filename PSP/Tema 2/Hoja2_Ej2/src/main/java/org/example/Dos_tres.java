package org.example;

public class Dos_tres extends Thread{
    public void run(){
        int suma = 0;
        int cuenta = 2;

        while(cuenta<=1000){
            if (cuenta%10==2||cuenta%10==3){
                suma+=cuenta;
            }
            cuenta++;
        }
        System.out.println("La suma de los acabado en 2/3 es: "+suma);
    }
}
