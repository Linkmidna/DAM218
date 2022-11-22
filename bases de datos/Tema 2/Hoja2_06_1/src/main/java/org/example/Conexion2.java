package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion2 {
    public static Connection getConexion() {
        Connection con = null;
        String url = "jdbc:mysql://127.0.0.1:3306/ligatercera";
        try {
            /*
            Para establecer que en una conexión se puedan ejecutar scripts,
            es necesario que, en la URL usada para establecer la conexión,
            añadamos la propiedad allowMultiQueries con valor true
             */
            con = DriverManager.getConnection(url+
                    "?allowMultiQueries=true&user=root&password=mysql&allowPublicKeyRetrieval=true&useSSL=false&" +
                    "useUnicode=true&serverTimezone=UTC");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }
}

