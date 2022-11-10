package org.example;

import java.io.IOException;

public class Ej_01 {
    public static void main(String[] args) {
        ProcessBuilder proceso = new ProcessBuilder("Notepad.exe");
        try {
            proceso.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
