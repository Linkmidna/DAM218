package org.example;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException {
        int opc = 1;
        File fichero = new File("personas.txt");
        if (!fichero.exists()) {
            fichero.createNewFile();
        }
        while (opc != 0) {
            System.out.println("---MENU---");
            System.out.println("1 Añadir persona\n" +
                    "2 Buscar persona\n" +
                    "3 Buscar nombre\n" +
                    "4 Apellidos comienzan por\n" +
                    "5 Eliminar persona\n" +
                    "6 Ordenar fichero\n" +
                    "0 Salir");

            System.out.println("Seleccione la accion que desea realizar");
            Scanner sc = new Scanner(System.in);
            opc = sc.nextInt();


            switch (opc) {
                case 1:
                    //Atraves del metodo, usando PrintWriter
                    añadirPersonas();
                    break;
                case 2:
                    buscarPersonas();
                    break;
                case 3:
                    buscarNombre();
                    break;
                case 4:
                    apellidosComienzanPor();
                    break;
                case 5:
                    eliminarPersona();
                    break;
                case 6:
                    ordenarFichero();
                    break;
                default:
                    System.out.println("Esa opcion no existe");

            }
        }
    }

    //El ejercicio mediante metodos
    //-----------------------AÑADIR PERSONAS---------------------
    //usando PrintWriter
    private static void añadirPersonas() {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("personas.txt", true));
            System.out.println("Nombre de la persona");
            String nombre = sc.nextLine();
            System.out.println("Introduce los apellidos");
            String apellidos = sc.nextLine();

            //Grabamos nombre y apellidos con formato "ape, nom" y en mayuscula
            pw.println(apellidos.toUpperCase() + ", " + nombre.toUpperCase());

            //Cerramos los flujos
            pw.flush();
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //Creamos una lista donde almacenamos las personas que hay en el fichero
    private static List<String> leerFichero(BufferedReader br) throws IOException {
        List<String> lista = new ArrayList<>();
        String linea = br.readLine();
        while (linea != null) {
            //añadir linea a linea
            lista.add(linea);
            linea = br.readLine();
        }
        return lista;
    }

    private static void buscarPersonas() {
        Scanner sc = new Scanner(System.in);
        //Instanciamos el BufferRead para leer line a linea el fichero
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("personas.txt"));
            //Cargamos la lista de personas
            List<String> lista = leerFichero(br);
            //Recogemos el nombre y apellidos de la persona
            System.out.println("introduce la información de la persona que desea buscar");
            System.out.println("Nombre:");
            String nombre = sc.nextLine();
            System.out.println("Apellidos: ");
            String apellidos = sc.nextLine();

            //Damos formato a la informacion recibida
            String persona = apellidos.toUpperCase() + ", " + nombre.toUpperCase();

            if (lista.contains(persona)) {
                System.out.println("La persona se encuentra en el fichero");
            } else {
                System.out.println("La persona no se encuentra en el fichero");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error de lectura del fichero");
        }
    }

    private static void buscarNombre() {
        Scanner sc = new Scanner(System.in);
        //Instanciamos el BufferRead para leer line a linea el fichero
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("personas.txt"));
            //Cargamos la lista de personas
            List<String> lista = leerFichero(br);
            //Recogemos el nombre y apellidos de la persona
            System.out.println("Introduce el nombre");
            String nombre = sc.nextLine();

            //leemos linea a linea y buscamos el nombre
            //Como si fuese una select (Stream)
            //X = a cada elemento de la lista  (x = apellidos, nombre)
            //split-> separa la cadena de caracteres en base a un caracter
            lista = lista.stream()
                    .filter(x -> x.split(", ")[1]
                            .equalsIgnoreCase(nombre))
                    .collect(Collectors.toList());

            if (lista.size() > 0) {
                lista.forEach(System.out::println);
            } else {
                System.out.println("No se encontraron personas con ese nombre");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error de lectura del fichero");
        }
    }

    private static void apellidosComienzanPor() {
        //Instanciamos la clase scanner
        Scanner sc = new Scanner(System.in);
        //Instanciamos BufferRead para leer linea a linea el fichero
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("personas.txt"));
            //Cargamos la lista de personas
            List<String> lista = leerFichero(br);

            //Recoge los primeros caracteres de apellidos
            System.out.println("Introduce los caracteres iniciales de apellidos");
            String apeIniciales = sc.nextLine();
            int num = apeIniciales.length(); //Guardamos la longitud

            lista = lista.stream()
                    .filter(x -> x.substring(0, num)
                            .equalsIgnoreCase(apeIniciales))
                    .collect(Collectors.toList());

            if (lista.size() == 0) {
                System.out.println("No se encontraron coincidencias");
            } else {
                lista.forEach(System.out::println);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
        }
    }

    private static void eliminarPersona() throws IOException {
        File fichero = new File("personas.txt");
        File ficheroAux = new File("ficheroAuxiliar");
        if (!ficheroAux.exists()) {
            ficheroAux.createNewFile();
        }
        //Instanciamos clase Scanner
        Scanner sc = new Scanner(System.in);
        //Instanciamos BufferReades para leer linea a linea el fichero
        BufferedReader br = null;
        //Instaciamos BufferWriter para escribir linea a linea a excepcion de la persona eliminada
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(fichero));
            bw = new BufferedWriter(new FileWriter(ficheroAux, true));
            //Convertimos la informacion del fichero en una lista
            List<String> lista = leerFichero(br);
            System.out.println("Introduce la información de la persona que desea eliminar");
            //Pedimos el nombre y los apellidos de la persona
            System.out.println("Nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Apellidos:");
            String apellidos = sc.nextLine();

            String persona = apellidos.toUpperCase() + ", " + nombre.toUpperCase();

            //leemos linea a linea
            boolean encontrado = false;
            String linea = br.readLine();

            for (int i =0; i<lista.size(); i++){
                if (lista.get(i).contains(persona)) {
                    encontrado = true;
                } else {
                    bw.write(lista.get(i));
                    bw.newLine();

                }
            }

            if (encontrado) {
                System.out.println("Se ha eliminado " + persona + " del fichero");
            } else {
                System.out.println("La persona indicada no se encuentra en el fichero");
            }

            br.close();
            bw.flush();
            bw.close();

            //USAMOS FICHERO AUXILIAR PARA ESCRIBIR
            fichero.delete();
            ficheroAux.renameTo(fichero);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error en la lectura del fichero");
        }
    }

    private static void ordenarFichero() {
        File fichero = new File("personas.txt");
        //Instancimos BufferReader para leer el fichero Linea a Linea
        BufferedReader br = null;
        //instanciamos BufferWriter para escribir el fichero Linea a Linea
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(fichero));

            List<String> lista = leerFichero(br);
            lista.sort(null); //Los strings y los integers se saben ordenar ellos solos
            //lista = lista.stream().sorted().collect(Collectors.toList());
            br.close();

            bw = new BufferedWriter(new FileWriter(fichero));
            for (String n : lista) {
                bw.write(n);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.out.println("Se ha ordenado el fichero alfabeticamente");

        } catch (FileNotFoundException e) {
            System.out.println("Error en la lectura del fichero");
        } catch (IOException e) {
            System.out.println("Error en la escritura del fichero");
        }
    }
}