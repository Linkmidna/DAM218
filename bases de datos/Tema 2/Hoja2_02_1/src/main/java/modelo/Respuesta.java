package modelo;

import java.util.Scanner;

public class Respuesta {
    private int numPreg;
    private int numResp;
    private String textoResp;
    private String rutaFoto;
    private byte correcta;
    private int vecesRespondida;

    public Respuesta(int numPreg, int numResp, String textoResp,  byte correcta) {
        this.numPreg = numPreg;
        this.numResp = numResp;
        this.textoResp = textoResp;
        this.rutaFoto = null;
        this.correcta = correcta;
        this.vecesRespondida=0;
    }

    public Respuesta(){
        this.vecesRespondida=0;

    }
    public int getNumPreg() {
        return numPreg;
    }

    public void setNumPreg(int numPreg) {
        this.numPreg = numPreg;
    }

    public int getNumResp() {
        return numResp;
    }

    public void setNumResp(int numResp) {
        this.numResp = numResp;
    }

    public String getTextoResp() {
        return textoResp;
    }

    public void setTextoResp(String textoResp) {
        this.textoResp = textoResp;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public byte getCorrecta() {
        return correcta;
    }

    public void setCorrecta(byte correcta) {
        this.correcta = correcta;
    }

    public int getVecesRespondida() {
        return vecesRespondida;
    }

    public void setVecesRespondida(int vecesRespondida) {
        this.vecesRespondida = vecesRespondida;
    }

    public void recogerRespuesta(int numpreg, int numresp){
        Scanner tec=new Scanner(System.in);
        try {
            System.out.println("Escribe el texto de la respuesta "+numresp+
                    " de la pregunta "+numpreg);
            String textoResp=tec.nextLine();
            do {
                System.out.println("Escribe 1 si es correcta y o si no lo es: ");
                correcta=tec.nextByte();
            }while(correcta<0 || correcta >1);


            System.out.println("Si lleva foto, escribe su ruta. Si no, pulsa ENTER ");
            rutaFoto=tec.nextLine();
            if(rutaFoto.length()==0)
                rutaFoto=null;


        }
        catch(NumberFormatException e){
            System.out.println("Formato de dato incorrecto");
        }
    }
}

