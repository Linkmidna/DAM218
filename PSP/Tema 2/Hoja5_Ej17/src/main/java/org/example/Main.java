package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        try{
            System.out.println("Introduce un int para empezar");
            int x = entrada.nextInt();

            ArrayEnteros a = new ArrayEnteros(x);
            HiloEscritor es = new HiloEscritor(a);
            HiloLector le = new HiloLector(a);
            es.start();
            le.start();
        }catch (InputMismatchException x){
            System.out.println("No has introducido un numero valido");
        }

    }
}