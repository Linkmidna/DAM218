package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion() {
        Connection con = null;
        String password = "root";
        String usuario = "root";
        String url = "jdbc:mysql://10.0.13.100:3306/preguntastest";
        try {
            con = DriverManager.getConnection(url+
                    "?user=julio&password=julio&allowPublicKeyRetrieval=true&useSSL=false&" +
                    "useUnicode=true&serverTimezone=UTC");

        } catch (SQLException e) {
            //e.printStackTrace();
        }
        return con;
    }
}

