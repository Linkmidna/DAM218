package es.julio.primerproyecto.modelo;

import javax.persistence.*;

@Entity
public class Alumno {
	@Id
	private int id;
	private String nombre;
	private float nota;
	
	public Alumno() {}
	
	public Alumno(int id,String nombre,float nota) {
		this.id=id;
		this.nombre=nombre;
		this.nota=nota;
	}
}


