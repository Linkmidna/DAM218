package org.example;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Random;

public class Ej_05 {
    public static void main(String[] args) {
        ProcessBuilder proceso = new ProcessBuilder("Notepad.exe");
        try {
            proceso.start();
            int[] ints = new int[10];
            for (int i=0;i<10;i++){
                ints[i]=Math.floor(Math.random()*10);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
