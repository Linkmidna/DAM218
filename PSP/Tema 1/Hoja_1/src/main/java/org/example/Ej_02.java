package org.example;

import java.io.IOException;

public class Ej_02 {
    public static void main(String[] args) {

        ProcessBuilder proceso = new ProcessBuilder();
        proceso.command("Notepad.exe");
        try {
            proceso.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}