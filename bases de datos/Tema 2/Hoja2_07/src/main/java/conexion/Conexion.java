package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion() {
        Connection con = null;
        String password = "root";
        String usuario = "root";
        String url = "jdbc:mysql://localhost:3306/concurso";
        try {
            con = DriverManager.getConnection(url+
                    "?user=root&password=root&allowPublicKeyRetrieval=true&useSSL=false&" +
                    "useUnicode=true&serverTimezone=UTC");

        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
            e.printStackTrace();
        }
        return con;
    }
}
