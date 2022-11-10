package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException {

        //Creamos variable fichero
        File alumnos = new File("alumnos.txt");

        //Comprobamos que el fichero existe
        if (!alumnos.exists()) {
            //Creamos fichero
            alumnos.createNewFile();
        }

        //Leemos fichero
        try{
            FileReader fr = new FileReader(alumnos);
            List<String> lista = leerFichero(fr);

            int edad = 20;
                int leido=0;
                while ((leido=fr.read())!=-1){

                }

        }catch (IOException er){
            System.out.println("Error en la lectura del fichero");
        }

    }
    private static List<String> leerFichero(FileReader fr) throws IOException {
        List<String> lista = new ArrayList<String>();
        String linea = String.valueOf(fr.read());
        while (linea != null) {
            //añadir linea a linea
            lista.add(linea);
            linea = String.valueOf(fr.read());
        }
        return lista;
    }
}
