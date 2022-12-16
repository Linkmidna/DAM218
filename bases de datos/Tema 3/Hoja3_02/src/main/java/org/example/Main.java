package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner entrada = new Scanner(System.in);
            String opc;


            EntityManagerFactory emf =
                    Persistence.createEntityManagerFactory( "grupos.odb");
            EntityManager em= emf.createEntityManager();

        Connection con=Conexion.getConexion();
        GestorConexion gesCon = new GestorConexion(con,em);

            do {
                System.out.println("---Introduce la opción que quieras---\n" +
                        "a- Añadir grupos\n" +
                        "b- Añadir canciones\n" +
                        "c- Obtener datos de grupo\n" +
                        "d- Añadir canción\n" +
                        "e- Asignar contacto\n" +
                        "f- Eliminar canciones\n" +
                        "g- Obtener datos de canción\n" +
                        "h- Modificar grupo de canción\n" +
                        "i- Modificar mail\n" +
                        "0- salir\n");
                opc= entrada.nextLine();

                switch (opc)
                {
                    case "a":
                        gesCon.AñadirGrupos();
                        break;
                    case "b":
                        gesCon.AñadirCanciones();
                        break;
                    case "c":
                        gesCon.BuscarGrupo();
                        break;
                    case "d":
                        gesCon.AñadirCancion();
                        break;
                    case "e":
                        gesCon.AsignarContacto();
                        break;
                    case "f":

                        break;
                    case "g":
                        gesCon.BuscarCancion();
                        break;
                    case "h":
                        gesCon.ModificarCancion();
                        break;
                    case "i":

                        break;

                    case "0":
                        System.out.println("Gracias por utilizar nuestro programa");
                        em.close();
                        emf.close();
                        break;
                    default:
                        System.out.println("Introduce una opción válida");
                        break;
                }

            }while(!opc.equalsIgnoreCase("0"));
        }
    }