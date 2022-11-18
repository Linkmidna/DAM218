package org.Ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    public static Connection getConexion() {
        Connection con = null;

        //MySQL local -> root
        String password = "veronica";
        String usuario = "veronica";

        String url = "jdbc:mysql://10.0.13.100:3306/preguntastest";
        try {
            con = DriverManager.getConnection(url+
                    "?user=veronica&password=veronica&allowPublicKeyRetrieval=true&useSSL=false&" +
                    "useUnicode=true&serverTimezone=UTC");
        } catch (SQLException e) {
            //e.printStackTrace();
        }
        return con;
    }
}
