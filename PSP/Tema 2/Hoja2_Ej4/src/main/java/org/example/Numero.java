package org.example;

import java.util.Scanner;

public class Numero extends Thread{
    boolean acierto = false;

    int num;
    int numUsuario;


    public void run(){
        num = (int) (Math.random() * 10)+1;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce un numero del 1 al 10");
        while(acierto==false){
            System.out.println("Dame un numero: ");
            numUsuario=entrada.nextInt();
            if (numUsuario == num){
                System.out.println("GANASTE");
                acierto=true;
            }
        }
    }

    public boolean isAcierto(){
        return acierto;
    }
}
