package org.example;

import java.io.*;

public class Cuenta_lineas extends Thread{
    String nombre;
    public Cuenta_lineas(String nombre){
        this.nombre=nombre;
    }
    public void run(){
        int numLineas=0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File(nombre)));

            while(br.readLine()!=null){
                numLineas++;
            }
            System.out.println("El numero de lineas en "+nombre+" es: "+numLineas);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
