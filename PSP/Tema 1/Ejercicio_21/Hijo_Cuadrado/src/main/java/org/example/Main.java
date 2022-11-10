package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String linea;
        Scanner entrada = new Scanner(System.in);
        linea= entrada.nextLine();
        int num = Integer.parseInt(linea);
        int cuadrado = num*num;
        System.out.println(cuadrado);
    }
}