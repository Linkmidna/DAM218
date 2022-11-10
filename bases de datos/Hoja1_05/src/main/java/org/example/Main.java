package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String texto;
        int opc;
        do {
            System.out.println("1. Añadir futbolista.");
            System.out.println("2. Listar futbolistas");
            System.out.println("3. Listar futbolistas de equipo");
            System.out.println("4. Buscar futbolista");
            System.out.println("5. Modificar equipo de futbolista");
            System.out.println("6. Modificar datos de futbolista");
            System.out.println("7. Eliminar futbolista");
            System.out.println("8. Crear FUTBOLISTAS.DAT");
            System.out.println("0. Salir");
            opc= entrada.nextInt();

            switch(opc){
                case 1:

                break;
            }
        }while (opc!=0);
    }
}