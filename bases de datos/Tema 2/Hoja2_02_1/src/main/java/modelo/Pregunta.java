package modelo;

import java.time.LocalDate;
import java.util.Scanner;

public class Pregunta {
    private int numPreg;
    private String enunciado;
    private String categoria;
    private int nivel;
    private int tipo;
    private String rutaFoto;
    private String rutaAudio;
    private int vecesFormulada;
    private int vecesAcertada;
    private LocalDate fechaCancel;

    public Pregunta(String enunciado, String categoria, int tipo, int nivel) {
        this.enunciado = enunciado;
        this.categoria = categoria;
        this.nivel = nivel;
        this.tipo = tipo;
        this.rutaFoto = null;
        this.rutaAudio = null;
        this.vecesAcertada=0;
        this.vecesFormulada=0;
        fechaCancel=null;
    }

    public int getNumPreg() {
        return numPreg;
    }

    public void setNumPreg(int numPreg) {
        this.numPreg = numPreg;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public String getRutaAudio() {
        return rutaAudio;
    }

    public void setRutaAudio(String rutaAudio) {
        this.rutaAudio = rutaAudio;
    }

    public int getVecesFormulada() {
        return vecesFormulada;
    }

    public void setVecesFormulada(int vecesFormulada) {
        this.vecesFormulada = vecesFormulada;
    }

    public int getVecesAcertada() {
        return vecesAcertada;
    }

    public void setVecesAcertada(int vecesAcertada) {
        this.vecesAcertada = vecesAcertada;
    }

    public LocalDate getFechaCancel() {
        return fechaCancel;
    }

    public void setFechaCancel(LocalDate fechaCancel) {
        this.fechaCancel = fechaCancel;
    }

    public void recogerPregunta(){
        Scanner tec=new Scanner(System.in);
        try {
            System.out.println("Escribe la pregunta: ");
            enunciado=tec.nextLine();
            System.out.println("Escribe la categoría: ");
            System.out.println("CIE-Ciencias, GEO-Geografía, HIS-Historia"+
                    "MUS-Musica, DEP-Deportes, SER-Series TV");
            categoria=tec.nextLine();
            do {
                System.out.println("Escribe el tipo (1 a 5) : ");
                tipo=tec.nextInt();
            }while(tipo<1 || tipo >5);
            do {
                System.out.println("Escribe el nivel (1 a 3) : ");
                nivel=tec.nextInt();
            }while(nivel<1 || nivel >5);

            tec.nextLine();

            System.out.println("Si lleva foto, escribe su ruta. Si no, pulsa ENTER ");
            rutaFoto=tec.nextLine();
            if(rutaFoto.length()==0)
                rutaFoto=null;
            System.out.println("Si lleva audio, escribe su ruta. Si no, pulsa ENTER ");
            rutaAudio=tec.nextLine();
            if(rutaAudio.length()==0)
                rutaAudio=null;

        }
        catch(NumberFormatException e){
            System.out.println("Formato de dato incorrecto");
        }
    }

}

