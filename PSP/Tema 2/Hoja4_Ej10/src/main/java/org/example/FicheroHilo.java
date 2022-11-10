package org.example;

public class FicheroHilo extends Thread{
    Fichero f;

    String Aescribir;

    public FicheroHilo(String nombre, String aux, Fichero f){
        super(nombre);
        this.f=f;
        Aescribir=aux;
    }
    public void run(){
        String delimitadores=" ";
        String[] palabrasSeparadas = Aescribir.split(delimitadores);
        synchronized (f){
            for (int i= 0; i<palabrasSeparadas.length;i++){
                f.escribir(palabrasSeparadas[i]);
            }
        }
    }
}
