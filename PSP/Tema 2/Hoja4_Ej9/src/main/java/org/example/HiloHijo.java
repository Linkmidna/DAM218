package org.example;

public class HiloHijo extends Thread{
    int numHijo;
    Contador cont;
    HiloHijo(int numHijo, Contador cont) {
        this.numHijo = numHijo;
        this.cont=cont;
    }

    public void run() {
        System.out.println("Mi numero es " + numHijo);
        for (int i=0;i<4;i++){
            System.out.println("El contador vale: "+cont.incContador(1));
        }

        System.out.println("Soy " + numHijo + " y he terminado");
    }
}
