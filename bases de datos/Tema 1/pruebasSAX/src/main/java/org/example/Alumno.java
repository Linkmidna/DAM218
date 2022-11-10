package org.example;

public class Alumno {
    String nombre;
    int edad;

    public Alumno() {

    }

    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {

        return "Alumno{" + "nombre=" + nombre + ", edad=" + edad + '}';

    }
}