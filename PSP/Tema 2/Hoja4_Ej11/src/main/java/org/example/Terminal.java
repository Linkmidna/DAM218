package org.example;

public class Terminal extends Thread{
    int numCuenta;
    Servidor serv;
    Terminal(int numCuenta, Servidor serv) {
        this.numCuenta = numCuenta;
        this.serv=serv;
    }

    public void run() {
        System.out.println("Soy el terminal " + numCuenta);

        System.out.println("Se han conectado: "+serv.nuevaCuenta()+" cuentas.");


    }
}
