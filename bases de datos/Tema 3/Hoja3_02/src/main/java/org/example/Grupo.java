package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Grupo {
    @Id
    private int idGrupo;
    private String nombre;
    private String localidad;
    private String estilo;
    private boolean esGrupo;
    private int yearFundacion;

    private Contacto contacto;
    @OneToMany(mappedBy = "grupo")
    private List<Cancion> canciones;

    public Grupo(){
        canciones = new ArrayList<>();
    }

    public List<Cancion> getCanciones() { return canciones;}

    public Contacto getContacto() { return contacto;}

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

    public void setContacto(Contacto contacto) {this.contacto = contacto;}

    public void setCanciones(List<Cancion> canciones) {this.canciones = canciones; }

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
