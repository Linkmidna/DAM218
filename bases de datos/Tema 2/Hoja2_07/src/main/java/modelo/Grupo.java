package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Grupo {
    private int id;
    private String nombre;
    private String localidad;
    private String estilo;
    private boolean esgrupo;
    private int annoEstreno;
    private String fechaGrab;
    private String comp;
    private List<Cancion> canciones;

    public Grupo(){
        canciones=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isEsgrupo() {
        return esgrupo;
    }

    public void setEsgrupo(boolean esgrupo) {
        this.esgrupo = esgrupo;
    }

    public int getAnnoEstreno() {
        return annoEstreno;
    }

    public void setAnnoEstreno(int annoEstreno) {
        this.annoEstreno = annoEstreno;
    }

    public String getFechaGrab() {
        return fechaGrab;
    }

    public void setFechaGrab(String fechaGrab) {
        this.fechaGrab = fechaGrab;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public boolean addCancion(Cancion cancion){
        Optional<Cancion> opt=canciones.stream().filter(c ->c.getNum()==cancion.getNum()).findFirst();
        if(opt.isEmpty()){
            canciones.add(cancion);
            return true;
        }
        else {
            return false;
        }

    }
}
