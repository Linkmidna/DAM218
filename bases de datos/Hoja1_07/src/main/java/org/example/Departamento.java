package org.example;

import java.util.ArrayList;

public class Departamento {
    ArrayList<Empleado> empleados;
    public String telefono;
    public String tipo;
    public String nombre;
    public String codigo;

    public Departamento() {
    }

    public Departamento(String telefono, String tipo, String nombre, String codigo) {
        this.telefono = telefono;
        this.tipo = tipo;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public void addEmpleado(int salario, String puesto, String nombre){
        Empleado empleado = new Empleado(salario,puesto,nombre);
        empleados.add(empleado);
    }
}
