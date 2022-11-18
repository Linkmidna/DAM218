package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Connection con=Conexion.getConexion();
            GestorConexion gesCon = new GestorConexion(con);
            Scanner entrada = new Scanner (System.in);
            int opc;
            do{
                System.out.println("1. Crear datos_coches DB");
                System.out.println("2. algo de coches tambien?");
                System.out.println("3. otra cosa");
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