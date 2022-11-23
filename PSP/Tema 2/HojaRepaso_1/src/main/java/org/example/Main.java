package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ProcessBuilder p = new ProcessBuilder("cmd","/c","comp","fich1.txt","fich2.tx");

        File dirOut = new File("salida.txt");
        File dirErr = new File("error.txt");

        p.redirectOutput(dirOut);
        p.redirectError(dirErr);
        p.start();
    }
}