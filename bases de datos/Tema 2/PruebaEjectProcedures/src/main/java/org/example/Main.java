package org.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Titulo de la cancion votada:");
        String tit = entrada.nextLine();
        System.out.println("Usuario que vota:");
        String usu = entrada.nextLine();
        Connection con = Conexion.getConexion();

        try{
            String sql="{call votar(?,?)}";
            CallableStatement st = con.prepareCall(sql);
            st.setString(1,usu);
            st.setString(2,tit);
            st.executeUpdate();
            System.out.println("Se ha realizado el voto");
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}