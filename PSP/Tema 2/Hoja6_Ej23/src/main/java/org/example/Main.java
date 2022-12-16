package org.example;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore sema = new Semaphore(0);
        Bienvenida b = new Bienvenida();

        for (int i=1;i<=15;i++){
            new Alumno(b,sema).start();
        }

        new Profesor(b,sema).start();

    }
}