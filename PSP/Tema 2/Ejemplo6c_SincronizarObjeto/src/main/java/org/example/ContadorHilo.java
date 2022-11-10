package org.example;

public class ContadorHilo extends Thread{
    Contador cont;
    ContadorHilo(String p_nombre, Contador p_cont){
        super(p_nombre);
        this.cont=p_cont;
    }
    //Método para incrementar el contador
    public void run(){
        for(int i=0;i<3;i++){
            synchronized(cont){
                cont.incContador(1);

            }
        }
        System.out.println("Fin "+getName()+"...");
    }
}
