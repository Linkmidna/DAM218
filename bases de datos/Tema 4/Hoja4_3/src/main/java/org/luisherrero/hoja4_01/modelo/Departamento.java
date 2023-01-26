package org.luisherrero.hoja4_01.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="empleados")
public class Departamento {
	@Id
	private long id;
	@Column(length = 50,nullable = false)
	private String nombre;
	@Column(length = 50)
	private String localidad;
	@OneToMany(mappedBy="departamento",cascade = CascadeType.ALL)
	private List<Empleado> empleados;
	
	public Departamento() {
		empleados=(List) new  ArrayList<Empleado>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public void setId(long id) {
		this.id=id;
	}
	public long getId() {
		return id;
	}
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	public void addEmpleado (Empleado empleado) {
		this.empleados.add(empleado);
		empleado.setDepartamento(this);
	}
	public void removeEmpleado(Empleado empleado) {
		this.empleados.remove(empleado);
		empleado.setDepartamento(null);
	}

	
	
	
}
