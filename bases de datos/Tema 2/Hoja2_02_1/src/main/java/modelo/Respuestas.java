package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Respuestas {
    private int numPreg;
    private int numeroRespuestas;
    private ArrayList<Respuesta> respuestas;

    public Respuestas(int numPreg, ArrayList<Respuesta> respuestas) {
        this.numPreg = numPreg;
        this.respuestas = respuestas;
        numeroRespuestas=respuestas.size();
    }

    public Respuestas(int numPreg) {
        this.numPreg = numPreg;
        respuestas = new ArrayList();
        this.numeroRespuestas=0;
    }

    public void cargarRespuestas(int numpreg, int numRespuestas){
        for(int i=0;i<numRespuestas;i++){
            Respuesta r=new Respuesta();
            r.recogerRespuesta(numpreg, i);
            respuestas.add(r);
        }

    }
    public void cargarRespuestas(){
        try{
            BufferedReader fich=new BufferedReader(new FileReader("nuevas_respuestas.csv"));
            String linea=fich.readLine();
            while(linea!=null){
                String [] datos=linea.split(";");
                if (Integer.parseInt(datos[0])==numPreg){
                    Respuesta respuesta = new Respuesta(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]),datos[2],Byte.parseByte(datos[3]));
                    respuestas.add(respuesta);
                }
                linea = fich.readLine();
            }
            fich.close();

        } catch (FileNotFoundException e) {
            System.out.println("ERROR No se ha encontrado el archivo.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getNumPreg() {
        return numPreg;
    }

    public int getNumeroRespuestas() {
        return numeroRespuestas;
    }

    public ArrayList<Respuesta> getRespuestas() {
        return respuestas;
    }
}
