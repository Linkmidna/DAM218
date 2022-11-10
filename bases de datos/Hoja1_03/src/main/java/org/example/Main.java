package org.example;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int opc;
        String linea;
        Scanner entrada = new Scanner(System.in);
        try {
        File personas = new File("PERSONAS.txt");
        FileWriter escritura = new FileWriter(personas,true);

            PrintWriter fOut;
            BufferedReader fIn;
            do {
                System.out.println("1. Añadir persona.");
                System.out.println("2. Buscar persona.");
                System.out.println("3. Buscar nombre.");
                System.out.println("4. Apellidos comienzan por.");
                System.out.println("5. Eliminar persona.");
                System.out.println("6. Ordenar fichero");
                System.out.println("0. Salir");

                opc=entrada.nextInt();

                switch(opc){
                    case 1:
                        fOut = new PrintWriter(escritura);
                        System.out.println("Introduce el nombre de la persona:");
                        String nombre1 = entrada.next();
                        System.out.println("Introduce el apellido de la persona:");
                        String apellido1= entrada.next();
                        fOut.println(apellido1.toUpperCase()+", "+nombre1.toUpperCase());
                        fOut.close();
                    break;

                    case 2:
                        fIn = new BufferedReader(new FileReader(personas));
                        System.out.println("Introduce el nombre de la persona:");
                        String nombre2 = entrada.next();
                        System.out.println("Introduce el apellido de la persona:");
                        String apellido2= entrada.next();
                        linea=fIn.readLine();
                        while(linea!=null){
                            if (linea.equals(apellido2.toUpperCase()+", "+nombre2.toUpperCase())){
                                System.out.println("La persona se encuentra en el fichero.");
                            }else System.out.println("No se encuentra en el fichero.");
                            linea=fIn.readLine();
                        }
                        fIn.close();
                    break;

                    case 3:
                        fIn = new BufferedReader(new FileReader(personas));
                        System.out.println("Introduce el nombre de la persona:");
                        String nombre3 = entrada.next();
                        linea=fIn.readLine();
                        while(linea!=null){
                            if (linea.contains(nombre3)){
                                System.out.println(linea);
                            }
                            linea=fIn.readLine();
                        }
                        fIn.close();
                    break;

                    case 4:
                        fIn = new BufferedReader(new FileReader(personas));
                        System.out.println("Introduce las primeras letras del apellido:");
                        String iniciales = entrada.next();
                        linea=fIn.readLine();
                        while(linea!=null){
                            if (linea.equalsIgnoreCase(linea.substring(0,iniciales.length()-1))){
                                System.out.println(linea);
                            }
                            linea=fIn.readLine();
                        }
                        fIn.close();

                    break;

                    case 5:
                        File noEliminados = new File("aux.txt");
                        FileWriter noElim = new FileWriter(noEliminados,true);
                        PrintWriter eliminar = new PrintWriter(noElim);
                        fIn = new BufferedReader(new FileReader(personas));
                        System.out.println("Introduce el nombre de la persona:");
                        String nombre5 = entrada.next();
                        System.out.println("Introduce el apellido de la persona:");
                        String apellido5= entrada.next();
                        linea=fIn.readLine();
                        while(linea!=null){
                            if (linea.equals(apellido5.toUpperCase()+", "+nombre5.toUpperCase())){
                                System.out.println("Se ha encontrado la coincidencia a eliminar.");
                            }else eliminar.println(linea);
                            linea=fIn.readLine();
                        }
                        eliminar.close();
                        fIn.close();
                        personas.delete();
                        noEliminados.renameTo(personas);
                }
            }while(opc!=0);

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}