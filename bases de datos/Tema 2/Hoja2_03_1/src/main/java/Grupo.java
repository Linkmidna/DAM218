public class Grupo {
    private int codgrupo;
    private String nombre;
    private String localidad;
    private String estilo;
    private boolean esgrupo;
    private int annoGrab;
    private String fechaEstreno;
    private String compania;

    public Grupo(){

    }

    public int getCodgrupo() {
        return codgrupo;
    }

    public void setCodgrupo(int codgrupo) {
        this.codgrupo = codgrupo;
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

    public int getAnnoGrab() {
        return annoGrab;
    }

    public void setAnnoGrab(int annoGrab) {
        this.annoGrab = annoGrab;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }
}
