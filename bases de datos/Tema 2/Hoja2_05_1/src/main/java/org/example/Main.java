package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Connection con=Conexion.getConexion();
            GestorConexion gesCon = new GestorConexion(con);
            Scanner entrada = new Scanner (System.in);
            int opc;
            do{
                System.out.println("1. Modificar votos de un grupo");
                System.out.println("2. Modificar ultimos 10 votos");
                System.out.println("3. Modificar ultimos 10 votos V2");
                System.out.println("0. Salir");

                opc = entrada.nextInt();

                switch(opc){
                    case 1:
                        gesCon.modificarVotos();
                        break;
                    case 2:
                        gesCon.gestionVotos();
                        break;
                    case 3:
                        gesCon.gestionVotosV2();
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