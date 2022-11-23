package org.example;

public class ArrayEnteros {
    private int[] array=new int[10];
    private boolean lleno ;

    public ArrayEnteros(int x){
        for (int i=0;i<array.length;i++){
            array[i]=x;
        }
        System.out.println("Se inicia el array en "+x);
        lleno=false;
    }

    public synchronized void Escribir(){
        while(lleno){
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for(int i=0;i<10;i++){
            array[i]+=1;
            System.out.print(array[i]+", ");
        }
        System.out.println("Se ha actualizado con el número "+array[0]);
        lleno=true;
        notifyAll();
    }

    public synchronized void Leer(){
        int suma;
        while(!lleno){
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        suma=0;
        for(int i=0;i<10;i++){
            suma+=array[i];
        }
        System.out.println("La suma total de todos los números del array es: "+suma);
        lleno=false;
        notifyAll();
    }
}
