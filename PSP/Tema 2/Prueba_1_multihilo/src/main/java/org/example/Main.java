package org.example;

public class Main {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();

        System.out.println("Hilo actual: "+t);
        System.out.println(t.getName());

        System.out.println(t.toString());

        System.out.println("Identificador del hilo: "+t.getId());

        System.out.println("Número de hilos dentro del grupo: "+t.activeCount());

        t.setName("Mi_hilito");

        System.out.println("Nuevo nombre: "+t.getName());

        System.out.println("Prioridad del hilo: "+t.getPriority());
        t.setPriority(1);
        System.out.println("Nueva prioridad del hilo: "+t.getPriority());

        try{
            for (int n=5 ; n>0 ; n--){
                System.out.println(n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}