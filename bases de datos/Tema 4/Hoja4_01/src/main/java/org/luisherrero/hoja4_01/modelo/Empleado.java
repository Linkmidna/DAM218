package org.luisherrero.hoja4_01.modelo;

import java.time.LocalDate;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;



@Entity
@Table(name = "empleados")
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NaturalId
	@Column(length = 45,nullable = false)
	private String nombre;
	@Column(length = 30)
	private String oficio;
	@Column(name="fecha_alta" , columnDefinition = "DATE")
	private LocalDate fechaAlta;
	@Column
	private Sueldo sueldo;
	public Empleado() {
		
	}
	public long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getOficio() {
		return oficio;
	}
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Sueldo getSueldo() {
		return sueldo;
	}
	public void setSueldo(Sueldo sueldo) {
		this.sueldo = sueldo;
	}
	
	
	
}
