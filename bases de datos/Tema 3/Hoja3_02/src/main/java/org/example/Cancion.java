package org.example;

import javax.persistence.*;

@Entity
public class Cancion {
    @Id
    private int idCancion;
    private String titulo;
    private String duracion;
    @ManyToOne
    private Grupo grupo;

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

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Cancion" +
                "id cancion: " + idCancion +
                ", titulo: " + titulo +
                ", duracion: " + duracion +
                ", grupo: " + grupo.getNombre();
    }
}
