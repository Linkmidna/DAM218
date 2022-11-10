package controlador;

import conexion.Conexion;
import modelo.Pregunta;
import modelo.Respuesta;
import modelo.Respuestas;
import modelo.Usuario;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GestorConexion {

    /********************************
     * METODO registrarUsuario
     * Pide por teclado los datos de un nuevo usuario y
     * añade el usuario a la tabla Usuarios
     **************************************/
    public void registrarUsuario2() {
        Connection con= Conexion.getConexion();
        Usuario usu =new Usuario();
        //carga los datos desde teclado
        usu.recogerDatos();
        Statement st=null;
        try {
            st=con.createStatement();
            //Como la fecha en la clase Usuario es un Date
            //lo convertimos al formato de fecha de MySQL
            //SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            //String f=df.format(usu.getFechaNac());

            String sql="INSERT INTO USUARIOS (nombre, apellidos, usuario, contraseña, fechanac) VALUES('"+
                    usu.getNombre()+"','"+usu.getApellidos()+"','"+usu.getUsuario()+"',md5('"+
                    usu.getPassword()+"'),'"+usu.getFechaNac()+"')";
            int n=st.executeUpdate(sql);
            if(n==1)
                System.out.println("Se ha registrado el usuario");
        } catch (SQLException ex) {
            System.out.println("Error en inserción de datos en base de datos");
            System.out.println ("ERROR: "+ex.getErrorCode()+" - "+ex.getMessage());

        }

        try {
            if(st!=null)
                st.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


    }

    public int registrarUsuario(Usuario usu) {
        int n=0;
        Connection con= Conexion.getConexion();
        if (con==null){
            System.out.println("No se ha establecido conexión");
            return -1;
        }

        PreparedStatement prst=null;
        try {
            String sql="INSERT INTO USUARIOS (nombre, apellidos, usuario, password,fechanac) " +
                    "VALUES (?,?,?,md5(?),?)";
            prst=con.prepareStatement(sql);
            prst.setString(1, usu.getNombre());
            prst.setString(2,usu.getApellidos());
            prst.setString(3, usu.getUsuario());
            prst.setString(4,usu.getPassword());
            prst.setString(5, usu.getFechaNac().toString());
            n=prst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error en inserción de datos en base de datos");
            System.out.println ("ERROR: "+ex.getErrorCode()+" - "+ex.getMessage());
            ex.printStackTrace();
        }

        try {
            if(prst!=null)
                prst.close();
            con.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return n;

    }
    /*******************************************************
     * METODO addPregunta
     * Recibe una pregunta
     * La añade a la tabla preguntas
     ***********************************************************/
    public void addPregunta(Pregunta p){
        Connection con= Conexion.getConexion();
        if(con==null){
            System.out.println("Error al establecer conexion");
            return;
        }
        PreparedStatement prepSt=null;
        try {
            prepSt=con.prepareStatement("INSERT INTO preguntas(enunciado,categoria,nivel,"
                    + "tipo,ruta_audio,ruta_foto) VALUES (?,?,?,?,?,?)");
            prepSt.setString(1,p.getEnunciado());
            prepSt.setString(2,p.getCategoria());
            prepSt.setInt(3, p.getNivel());
            prepSt.setInt(4, p.getTipo());
            prepSt.setString(5,p.getRutaFoto());
            prepSt.setString(6,p.getRutaAudio());
            prepSt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error en instrucción de inserción");
            System.out.println ("ERROR: "+ex.getErrorCode()+" - "+ex.getMessage());

        }
        try {
            if(prepSt!=null)
                prepSt.close();

        } catch (SQLException ex) {
            System.out.println("Error en cierre de conexion");
        }
    }

    /*******************************************************
     * METODO addRespuesta
     * Recibe unas respuestas
     * Las añade a la tabla respuestas
     ***********************************************************/

    public void addRespuestas(Respuestas respuestas){
        Connection con= Conexion.getConexion();
        if(con==null){
            System.out.println("Error al establecer conexion");
            return;
        }
        ArrayList<Respuesta> r = respuestas.getRespuestas();
        PreparedStatement prepSt=null;
        try {
            for (int i=0;i<r.size();i++){
                prepSt=con.prepareStatement("INSERT INTO respuestas(num_preg,num_resp,texto_resp,"
                        + "correcta,ruta_foto,veces_respondida) VALUES (?,?,?,?,?,?)");
                prepSt.setInt(1,r.get(i).getNumPreg());
                prepSt.setInt(2,r.get(i).getNumResp());
                prepSt.setString(3, r.get(i).getTextoResp());
                prepSt.setInt(4, r.get(i).getCorrecta());
                prepSt.setString(5,r.get(i).getRutaFoto());
                prepSt.setInt(6,r.get(i).getVecesRespondida());
                prepSt.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println("Error en instrucción de inserción");
            System.out.println ("ERROR: "+ex.getErrorCode()+" - "+ex.getMessage());

        }
        try {
            if(prepSt!=null)
                prepSt.close();

        } catch (SQLException ex) {
            System.out.println("Error en cierre de conexion");
        }
    }
}

