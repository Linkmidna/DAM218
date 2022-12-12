package org.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idGrupo;
    private String nombre;
    private String localidad;
    private String estilo;
    private boolean esGrupo;
    public int yearFundacion;

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
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

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public boolean isEsGrupo() {
        return esGrupo;
    }

    public void setEsGrupo(boolean esGrupo) {
        this.esGrupo = esGrupo;
    }

    public int getYearFundacion() {
        return yearFundacion;
    }

    public void setYearFundacion(int yearFundacion) {
        this.yearFundacion = yearFundacion;
    }

    @Override
    public String toString() {
        return "Grupo " +
                "id: " + idGrupo +
                ", nombre: '" + nombre +
                ", localidad: '" + localidad +
                ", estilo: " + estilo +
                ", esGrupo: " + esGrupo +
                ", año fundacion: " + yearFundacion;
    }
}
