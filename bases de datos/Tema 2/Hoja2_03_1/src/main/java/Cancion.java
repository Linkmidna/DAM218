public class Cancion {
    private int numCancion;
    private int grupo;
    private String duracion;
    private String titulo;
    private int total_votos;

    public Cancion(){

    }

    public int getNumCancion() {
        return numCancion;
    }

    public void setNumCancion(int numCancion) {
        this.numCancion = numCancion;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTotal_votos() {
        return total_votos;
    }

    public void setTotal_votos(int total_votos) {
        this.total_votos = total_votos;
    }
}
