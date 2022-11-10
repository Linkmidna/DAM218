package org.example;

public class Ejemplo6a {
    public static void main(String[] args) {
        //Creamos cuatro hilos que van a compartir el recurso compartido Contador.
        Contador cont=new Contador();
        ContadorHilo hilo1=new ContadorHilo("Hilo1",cont);
        ContadorHilo hilo2=new ContadorHilo("Hilo2",cont);
        ContadorHilo hilo3=new ContadorHilo("Hilo3",cont);
        ContadorHilo hilo4=new ContadorHilo("Hilo4",cont);
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        try{
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
        }catch(InterruptedException e){
            System.out.println("Interrupcion del hilo...");
        }
        System.out.println("Terminamos el programa...");
    }
}
