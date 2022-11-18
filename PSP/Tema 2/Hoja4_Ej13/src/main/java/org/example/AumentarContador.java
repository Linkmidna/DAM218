package org.example;

public class AumentarContador extends Thread{
    Contador cont;
    public AumentarContador(String nombre, Contador cont) {
        super(nombre);
        this.cont=cont;
    }

    public void run() {
        System.out.println("Soy el " + this.getName());
        try {
            for (int i = 0; i < 10; i++) {
                cont.incContador();
                AumentarContador.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("El contador vale: "+cont.verContador());


    }

}
