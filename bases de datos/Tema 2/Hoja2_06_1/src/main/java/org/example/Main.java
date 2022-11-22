package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Connection con=Conexion.getConexion();
            Connection con2=Conexion2.getConexion();
            GestorConexion gesCon = new GestorConexion(con,con2);
            Scanner entrada = new Scanner (System.in);
            int opc;
            do{
                System.out.println("1. Crear datos_coches DB por lineas");
                System.out.println("2. Crear datos_coches DB de golpe");
                System.out.println("3. Crear Municipios DB");
                System.out.println("4. Siguiente jornada futbolera");
                System.out.println("0. Salir");

                opc = entrada.nextInt();

                switch(opc){
                    case 1:
                        gesCon.crearCochesDB();
                        break;
                    case 2:
                        gesCon.crearCochesDBV2();
                        break;
                    case 3:
                        gesCon.crearMunicipios();
                        break;
                    case 4:
                        gesCon.siguienteJornada();
                        break;
                    default:
                        System.out.println("Gracias por usar nuestro programa");
                }
            }while(opc!=0);

            if(con!=null)
                con.close();
        } catch (SQLException e) {
            System.err.println("Se ha producido un error en el cierre de la conexión a la BD");
        }
    }
}