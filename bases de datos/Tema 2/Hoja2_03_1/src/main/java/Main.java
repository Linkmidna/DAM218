import java.sql.Connection;
import java.sql.PreparedStatement;
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
            System.out.println("1. Listado de grupos");
            System.out.println("2. Listado de canciones");
            System.out.println("3. Numero de canciones por grupo");
            System.out.println("4. Canciones de un grupo");
            System.out.println("5. Las 5 canciones más votadas");
            System.out.println("6. Grupos sin canciones");
            System.out.println("7. Los ultimos 5 votos");
            System.out.println("8. Eliminar canciones de un grupo");
            System.out.println("9. Modificar datos de un grupo");
            System.out.println("0. Salir");

            opc = entrada.nextInt();

            switch(opc){
                case 1:
                    gesCon.listGrupos();
                    break;
                case 2:
                    gesCon.listCanciones();
                    break;
                case 3:
                    gesCon.countGrupoCanciones();
                    break;
                case 4:
                    gesCon.cancionesPorGrupo();
                    break;
                case 5:
                    gesCon.masVotadas();
                    break;
                case 6:
                    gesCon.gruposSinCanciones();
                    break;
                case 7:
                    gesCon.ultimosVotos();
                    break;
                case 8:

                    break;
                case 9:

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
