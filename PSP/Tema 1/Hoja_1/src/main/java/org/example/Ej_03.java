package org.example;

import java.io.IOException;

public class Ej_03 {
    public static void main(String[] args) {
        ProcessBuilder proceso = new ProcessBuilder("Notepad.exe", "D:\\Usuarios\\dam218\\Desktop\\prueba.txt");
        try {
            proceso.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
