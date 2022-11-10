package org.example;

public class Hilo extends Thread{



    public void run()
    {
        System.out.println("mi nombre es: "+getName());
        System.out.println("Mi prioridad es: "+getPriority());
        System.out.println("Mi id es: "+getId());
    }

}
