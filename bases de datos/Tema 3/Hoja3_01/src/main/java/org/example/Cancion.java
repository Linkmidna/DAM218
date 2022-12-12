package org.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCancion;
    private String titulo;
    private String duracion;
    private int grupo;

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Cancion" +
                "id cancion: " + idCancion +
                ", titulo: " + titulo +
                ", duracion: " + duracion +
                ", grupo: " + grupo;
    }
}
