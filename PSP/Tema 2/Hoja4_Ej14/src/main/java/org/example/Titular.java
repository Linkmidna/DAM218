package org.example;

public class Titular extends Thread{

    CuentaBancaria cuenta;
    Titular(String nombre, CuentaBancaria cuenta) {
        super(nombre);
        this.cuenta=cuenta;
    }

    public void run() {
        System.out.println("Soy el titular " + this.getName());
        cuenta.ingresar(100);
        System.out.println("El saldo global es: "+cuenta.consultarSaldo());


    }
}
