package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection con = Conexion.getConexion();
        Scanner entrada = new Scanner(System.in);
        try{
            Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            System.out.println("Introduce el nombre del grupo:");
            String nom = entrada.nextLine();

            ResultSet hr = stmt.executeQuery("SELECT  aqui metes las cosas que te pide de los grupos");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}