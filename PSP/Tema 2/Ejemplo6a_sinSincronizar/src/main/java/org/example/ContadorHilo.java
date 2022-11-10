package org.example;

/*Cada hilo accedera tres veces al recurso compartido Contador y lo
 incrementará en 1, durmiendo un tiempo aleatorio en cada iteración*/

public class ContadorHilo extends Thread{
    Contador cont;
    ContadorHilo(String p_nombre, Contador p_cont){
        super(p_nombre);
        this.cont=p_cont;
    }
    //Método para incrementar el contador
    public void run(){
        for(int i=0;i<3;i++){
            cont.incContador(1);

        }
        System.out.println("Fin "+getName()+"...");
    }
}