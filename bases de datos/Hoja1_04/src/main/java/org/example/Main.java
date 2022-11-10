package org.example;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String texto;
        int opc;
        do {
            System.out.println("1. Listado de futbolistas.");
            System.out.println("2. Listado de futbolistas de equipo");
            System.out.println("3. Añadir futbolista");
            System.out.println("4. Modificar puesto de futbolista");
            System.out.println("5. Eliminar futbolista");
            System.out.println("0. Salir");
            opc = entrada.nextInt();

            switch (opc) {
                case 1:
                    BufferedReader fich1 = null;

                    try {
                        fich1 = new BufferedReader(new FileReader("futbolistas.csv"));
                        String linea = fich1.readLine();
                        while (linea != null) {
                            String[] datos = linea.split(",");
                            texto = String.format("%-5s%-15s%-25s%-20s%-15s%-8s%-12s%3s", datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[7]);
                            System.out.println(texto);
                            linea = fich1.readLine();
                        }
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                break;

                case 2:
                    System.out.println("Introducir codigo de equipo");
                    String cod= entrada.next();
                    boolean exist=false;
                    BufferedReader fich2=null;
                    try {
                        fich2=new BufferedReader(new FileReader("futbolistas.csv"));
                        String linea2=fich2.readLine();
                        while(linea2!=null){
                            String [] datos=linea2.split(",");
                            if (datos[7].equalsIgnoreCase(cod)){
                                exist=true;
                                texto = String.format("%-5s%-15s%-25s%-20s%-15s%-8s%-12s%3s", datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[7]);
                                System.out.println(texto);
                            }
                        linea2 = fich2.readLine();
                        }
                        if (!exist){
                            System.out.println("No hay ningun futbolista o no existe el equipo");
                        }
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                break;

                case 3:
                    Futbolista fut = new Futbolista();
                    PrintWriter fichOutput=null;
                    try {
                        fichOutput=new PrintWriter(new FileWriter("futbolistas.csv",true));
                        fut.cargarPorTeclado();
                        String textAltura=String.format(Locale.US,"4.2f",fut, fut.getAltura());
                        fichOutput.println(fut.getNum()+","+fut.getNombre()+","+fut.getApellidos()+","+fut.getAlias()+","+fut.obtenerPuestoString()+","+textAltura+","+fut.getFechaNac()+","+fut.getCodEq());
                        System.out.println("Añadido el futbolista");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        } while (opc != 0);
    }
}