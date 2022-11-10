package org.example;

import java.io.*;
import java.util.Scanner;

public class datosEnFichero {
    public static void main(String[] args) {
        try {
            File fichero = new File("FichData.dat");
            FileOutputStream fOut = new FileOutputStream(fichero);
            DataOutputStream dOut = new DataOutputStream(fOut);

            String[] nombres = {"Pedro","Manolo","Juan","Antonio","Alfredo"};
            int[] edades = {14,65,23,45,27};
            for (int i=0;i<5;i++){
                dOut.writeUTF(nombres[i]);
                dOut.writeInt(edades[i]);
            }

            dOut.close();
            fOut.close();


            FileInputStream fIn = new FileInputStream(fichero);
            DataInputStream dIn = new DataInputStream(fIn);

            while(fIn.available()>0){
                String nom = dIn.readUTF();
                int ed = dIn.readInt();
                if (ed>=20 && ed <=30){
                    System.out.println(nom);
                    System.out.println(ed);
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
