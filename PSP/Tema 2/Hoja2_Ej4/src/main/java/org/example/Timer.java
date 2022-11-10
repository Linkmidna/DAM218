package org.example;

public class Timer extends Thread{
    @Override
    public void run() {
        Numero num = new Numero();
        num.start();
        for (int i = 0; i<10 ; i++){
            try{
                sleep(1000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (num.isAcierto()==true){
                break;
            }
        }
        if (num.isAcierto()==false){
            System.out.println("Has perdido");
        }
        System.exit(0);
    }
}
