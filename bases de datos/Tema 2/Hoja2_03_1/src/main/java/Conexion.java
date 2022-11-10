import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion() {
        Connection con = null;
        String password = "root";
        String usuario = "root";
        String url = "jdbc:mysql://127.0.0.1:3306/concursomusica";
        try {
            con = DriverManager.getConnection(url+
                    "?user=root&password=mysql&allowPublicKeyRetrieval=true&useSSL=false&" +
                    "useUnicode=true&serverTimezone=UTC");

        } catch (SQLException e) {
            //e.printStackTrace();
        }

        return con;
    }
}

