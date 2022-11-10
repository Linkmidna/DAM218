package org.example;

import java.io.File;
import java.util.Scanner;

public class Ejercicio04 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opc;
        do {
            System.out.println( "1.Comprobar si es directorio.\n"+
                                "2.Obtener ficheros en directorio.\n"+
                                "3.Obtener tamaño de fichero.\n"+
                                "4.Obtener ruta del directorio actual.\n"+
                                "5.Eliminar fichero.\n"+
                                "6.Mover fichero.\n"+
                                "7.Renombrar fichero.\n"+
                                "0.Salir.");
            opc = entrada.nextInt();
            switch (opc){
                case 1:
                    System.out.println("Introduce la ruta del directorio:");
                    String ruta1 = entrada.next();
                    File fichero1 = new File(ruta1);
                    if (fichero1.exists()){
                        if (fichero1.isDirectory()){
                            System.out.println("Es un directorio");
                        }else System.out.println("No es un directorio");
                    }else System.out.println("El directorio no existe.");
                    break;

                case 2:
                    System.out.println("Introduce el nombre del directorio:");
                    String directorio2 = entrada.next();
                    File fichero2= new File(directorio2);
                    for (File i : fichero2.listFiles() ) {
                        if (i.isDirectory()){
                            System.out.println("Nombre: "+i.getName()+"  D");
                        }else System.out.println("Nombre: "+i.getName()+"  F");
                    }
                    break;

                case 3:
                    System.out.println("Introduce el nombre del directorio:");
                    String directorio3 = entrada.next();
                    File fichero3= new File(directorio3);
                    System.out.println("Introduce el nombre del fichero:");
                    String ruta3 = entrada.next();
                    if (fichero3.exists()){
                        for (File i : fichero3.listFiles() ) {
                            if (i.getName().equalsIgnoreCase(ruta3)){
                                System.out.println("Nombre: "+i.getName()+"\nTamaño en Bytes: "+i.length()+"\n");
                            }
                        }
                    }else System.out.println("El directorio no existe");
                    break;

                case 4:
                    File fichero4 = new File(".");
                    System.out.println("La ruta es: "+fichero4.getAbsolutePath());
                    break;

                case 5:
                    System.out.println("Introduce la ruta absoluta del fichero:");
                    String ruta5 = entrada.next();
                    File fichero5 = new File(ruta5);
                    if (fichero5.exists()){
                        fichero5.delete();
                        System.out.println("El fichero ha sido eliminado");
                    }else System.out.println("El fichero no existe");
                    break;

                case 6:
                    System.out.println("Introduce la ruta absoluta del fichero:");
                    String ruta6 = entrada.next();
                    File fichero6 = new File(ruta6);
                    if (fichero6.exists()){
                        System.out.println("Introduce la ruta del destino:");
                        String ruta6_6 = entrada.next();
                        fichero6.renameTo(new File(ruta6_6));
                        System.out.println("El fichero se ha movido correctamente");
                    }else System.out.println("El fichero no existe");
                    break;

                case 7:
                    System.out.println("Introduce la ruta absoluta del fichero:");
                    String ruta7 = entrada.next();
                    File fichero7 = new File(ruta7);
                    if (fichero7.exists()){
                        System.out.println("Introduce el nuevo nombre (ruta absoluta):");
                        String ruta7_7 = entrada.next();
                        fichero7.renameTo(new File(ruta7_7));
                        System.out.println("El fichero se ha renombrado correctamente");
                    }else System.out.println("El fichero no existe");
                    break;
            }
        }while(opc != 0);
    }
}
