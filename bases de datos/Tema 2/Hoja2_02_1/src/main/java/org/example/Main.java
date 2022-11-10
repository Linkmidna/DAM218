package org.example;

import conexion.Conexion;
import controlador.GestorConexion;
import modelo.Pregunta;
import modelo.Respuesta;
import modelo.Respuestas;
import modelo.Usuario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner tec = new Scanner(System.in);
        int opc;
        GestorConexion gestorCon = new GestorConexion();

        do {
            System.out.println("1. Registrarse como nuevo usuario");
            System.out.println("2. Añadir nuevas preguntas");
            System.out.println("3. Añadir nuevas respuestas");
            System.out.println("0. Salir");
            opc = tec.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Vas a registrarte como nuevo usuario (Pulsa S si quieres continuar) :");
                    if (tec.nextLine().equalsIgnoreCase("S")) {
                        Usuario usu = new Usuario();
                        //carga los datos desde teclado
                        usu.recogerDatos();
                        int n = gestorCon.registrarUsuario(usu);
                        if (n == 1)
                            System.out.println("Has sido registrado como usuario de la BD Test");
                        else
                            System.out.println("No se ha podido realizar el registro");
                    } else {
                        System.out.println("Registro cancelado");
                    }
                    break;

                case 2:
                    try{
                        BufferedReader fich=new BufferedReader(new FileReader("nuevas_preguntas.csv"));
                        String linea=fich.readLine();
                        while(linea!=null){
                            String [] datos=linea.split(";");
                            Pregunta pregunta = new Pregunta(datos[0],datos[1],Integer.parseInt(datos[2]),Integer.parseInt(datos[3]));
                            gestorCon.addPregunta(pregunta);
                            linea = fich.readLine();
                        }
                        fich.close();

                    } catch (FileNotFoundException e) {
                        System.out.println("ERROR No se ha encotnrado el archivo.");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 3:
                    Respuestas res63 = new Respuestas(63);
                    Respuestas res64 = new Respuestas(64);
                    res63.cargarRespuestas();
                    res64.cargarRespuestas();
                    gestorCon.addRespuestas(res63);
                    gestorCon.addRespuestas(res64);

                    break;

                case 0:
                    System.out.println("Gracias por usar nuestro programa");
                    break;

                default:
                    System.out.println("Introduce una opción válida");
                    break;
            }
        } while (opc != 0);
    }
}

