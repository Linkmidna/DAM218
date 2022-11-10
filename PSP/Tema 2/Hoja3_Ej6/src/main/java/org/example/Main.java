package org.example;

public class Main {
    public static void main(String[] args) {
        Tic tic = new Tic();
        Tac tac = new Tac();

        while(true){
            tic.start();
            tac.start();
        }

    }
}