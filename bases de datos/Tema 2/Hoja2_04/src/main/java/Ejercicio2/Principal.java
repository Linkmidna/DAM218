package Ejercicio2;

import java.sql.*;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Connection con = Conexion.getConexion();
        if (con != null) {

            //Instanciamos scanner
            boolean usuarioCorrecto = false;
            Scanner sc = new Scanner(System.in);

            String user = "";
            String password = "";
            while (usuarioCorrecto != true) {
                System.out.println("--------------INTRODUCE TU INFORMACION----------------");
                System.out.println("Usuario: ");
                user = sc.next();
                System.out.println("Contraseña");
                password = sc.next();

                System.out.println("Verificando usuario....");
                if (ValidarUsuario(user, password)) {
                    System.out.println("Usuario correcto");
                    usuarioCorrecto = true;
                } else {
                    System.out.println("Usuario incorrecto");
                    System.out.println("Intentelo de nuevo");
                }
            }
            obtenerNombreApellidos(user);
            añadirAcceso(user);
            test();
        }
    }

    public static boolean ValidarUsuario(String user, String password) {
        Connection con = Conexion.getConexion();
        boolean acceso = false;
        PreparedStatement prst;
        ResultSet r;
        String sql = "SELECT count(*) FROM usuarios WHERE usuario=? AND password=md5(?)";
        try {
            prst = con.prepareStatement(sql);
            prst.setString(1, user);
            prst.setString(2, password);
            r = prst.executeQuery();
            r.next();
            if (r.getInt(1) == 1) {
                acceso = true;
            }
            prst.close();
            r.close();
        } catch (SQLException e) {
            System.out.printf("ERROR " + e.getErrorCode() + "- " + e.getMessage());
        }
        return acceso;
    }

    public static void obtenerNombreApellidos(String user) {
        Connection con = Conexion.getConexion();

        String consulta = "SELECT usuario, nombre, apellidos FROM usuarios WHERE usuario = ?";

        PreparedStatement prepSt = null;
        ResultSet r = null;
        try {
            prepSt = con.prepareStatement(consulta);
            prepSt.setString(1, user);
            r = prepSt.executeQuery();
            int n = 0;
            while (r.next()) {
                n++;
                System.out.println("\nUsuario: " + r.getString(1) + "\t\nNombre: " + r.getString(2) + "\tApellidos: " + r.getString(3) + "\n");
            }
            r.close();
            prepSt.close();
        } catch (SQLException e) {
            System.out.println("Error " + e.getErrorCode() + " -> " + e.getMessage());
        }
    }

    public static void añadirAcceso(String user) {
        Connection con = Conexion.getConexion();

        //Modificamos el número de accesos
        String consulta = "update usuarios\n" +
                "set num_accesos=num_accesos+1\n" +
                "where usuario=?;";

        PreparedStatement prepSt = null;
        ResultSet r = null;
        try {
            prepSt = con.prepareStatement(consulta);
            prepSt.setString(1, user);
            int retorno = prepSt.executeUpdate();

            prepSt.close();
        } catch (SQLException e) {
            System.out.println("Error " + e.getErrorCode() + " -> " + e.getMessage());
        }


        //Mostramos el número de accesos actuales
        consulta = "select num_accesos\n" +
                "from usuarios \n" +
                "where usuario=?;";

        prepSt = null;
        r = null;
        try {
            prepSt = con.prepareStatement(consulta);
            prepSt.setString(1, user);
            r = prepSt.executeQuery();
            while (r.next()) {
                System.out.println("Has tenido " + r.getInt(1) + " accesos.");
            }
            r.close();
            prepSt.close();
        } catch (SQLException e) {
            System.out.println("Error " + e.getErrorCode() + " -> " + e.getMessage());
        }
    }

    public static void test() {
        Connection con = Conexion.getConexion();

        //Pedimos las preguntas
        String consulta = "select num_preg, enunciado\n" +
                "from preguntas \n" +
                "where tipo=2\n" +
                "order by rand()\n" +
                "limit 5;";

        Statement st = null;
        ResultSet r = null;

        try {
            st = con.createStatement();
            r = st.executeQuery(consulta);
            String enunciadoAnterior = "";

            while (r.next()) {
                int num_preg = r.getInt(1);
                String enunciado = r.getString(2);


                if (!enunciado.equalsIgnoreCase(enunciadoAnterior)) {
                    //Mostramos el enunciado
                    System.out.println("\n" + enunciado);

                    //Sumamos veces formulada
                    consulta = "update preguntas\n" +
                            "set veces_formulada=veces_formulada+1\n" +
                            "where num_preg=?;";
                    PreparedStatement prepSt = null;
                    //r2 = null;
                    try {
                        prepSt = con.prepareStatement(consulta);
                        prepSt.setInt(1, num_preg);
                        int retorno = prepSt.executeUpdate();
                        prepSt.close();
                    } catch (SQLException e) {
                        System.out.println("Error " + e.getErrorCode() + " -> " + e.getMessage());
                    }


                    //Mostramos las posibles respuestas
                    consulta = "select  num_resp, texto_resp\n" +
                            "from respuestas\n" +
                            "where num_preg =?;";


                    try {
                        prepSt = con.prepareStatement(consulta);
                        prepSt.setInt(1, num_preg);
                        ResultSet r2 = prepSt.executeQuery();

                        int n = 0;
                        while (r2.next()) {
                            System.out.println("\t" + r2.getInt(1) + "- " + r2.getString(2));
                            n++;
                        }

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("Seleccione la respuesta correcta");
                    int respuesta = new Scanner(System.in).nextInt();

                    //------------------HASTA AQUÍ FUNCIONA------------------------

                    //Comprobamos si la respuesta es correcta
                    consulta = "select correcta\n" +
                            "from respuestas\n" +
                            "where num_preg=? and num_resp=?;";

                    try {
                        prepSt = con.prepareStatement(consulta);
                        prepSt.setInt(1, num_preg);
                        prepSt.setInt(2, respuesta);
                        ResultSet r2 = prepSt.executeQuery();

                        int esCorrecta = 0;
                        while (r2.next()) {
                            esCorrecta = r2.getInt(1);
                        }


                        if (esCorrecta == 1) {
                            System.out.println("La respuesta es correcta");
                            //Actualizar dato en la tabla de
                            consulta = "UPDATE preguntas\n" +
                                    "SET veces_acertada = veces_acertada +1\n" +
                                    "WHERE num_preg=?;";

                            prepSt = null;
                            r2 = null;
                            try {
                                prepSt = con.prepareStatement(consulta);
                                prepSt.setInt(1, num_preg);
                                int retorno = prepSt.executeUpdate();

                                prepSt.close();
                            } catch (SQLException e) {
                                System.out.println("Error " + e.getErrorCode() + " -> " + e.getMessage());
                            }

                        } else {
                            System.out.println("La respuesta es incorrecta");
                        }

                        //Una vez que tenemos la respuesta Actualizamos el campo -> veces_respondida
                        consulta = "UPDATE respuestas \n" +
                                "SET veces_respondida = veces_respondida +1\n" +
                                "WHERE num_preg=? AND num_resp=?;";

                        prepSt = null;
                        r2 = null;
                        try {
                            prepSt = con.prepareStatement(consulta);
                            prepSt.setInt(1, num_preg);
                            prepSt.setInt(2, respuesta);
                            int retorno = prepSt.executeUpdate();
                            prepSt.close();
                        } catch (SQLException e) {
                            System.out.println("Error " + e.getErrorCode() + " -> " + e.getMessage());
                        }

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    //Ultimo paso
                    enunciadoAnterior = enunciado;
                }

                //Siguiente pregunta
                new Scanner(System.in).nextLine();
            }

            r.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
CONSULTAS

Obtener 5 preg aleatorias

select enunciado
from preguntas
where tipo=2
order by rand()
limit 5;
 */
