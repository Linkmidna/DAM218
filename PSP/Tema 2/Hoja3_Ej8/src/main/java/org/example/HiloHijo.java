package org.example;

public class HiloHijo extends Thread {
    int numHijo;
    HiloHijo(int numHijo) {
        this.numHijo = numHijo;
    }

    public void run() {
        System.out.println("Mi numero es " + numHijo);
        if (numHijo > 1) {
            HiloHijo hijo = new HiloHijo(numHijo - 1);
            hijo.start();
            try {
                hijo.join();
            } catch (InterruptedException e) {
                System.out.println("Interrupcion del hilo inesperada");
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Soy el hijo " + numHijo + " ejecutado " + i + " veces.");
            try {
                Thread.sleep((long) Math.random() * 600);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Soy " + numHijo + " y he terminado");
    }
}