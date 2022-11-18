package org.example;

public class DisminuirContador extends Thread{
    Contador cont;
    public DisminuirContador(String nombre, Contador cont) {
        super(nombre);
        this.cont=cont;
    }

    public void run() {
        System.out.println("Soy el " + this.getName());
        try {
            for (int i = 0; i < 10; i++) {
                cont.decContador();
                DisminuirContador.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("El contador vale: "+cont.verContador());


    }
}
