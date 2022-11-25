package controlador;

import conexion.Conexion;
import modelo.Cancion;
import modelo.Grupo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Controlador {
    public Controlador(){
   }
    public List<Cancion> cargarCanciones(){
        List<Cancion> lista;
        Connection con= Conexion.getConexion();
        if(con==null){
            return null;
        }
        else{
            Statement st=null;
            ResultSet res=null;
            String sql="SELECT numCancion,grupo,duracion,titulo,total_votos FROM canciones";
            try {
                st = con.createStatement();
                res=st.executeQuery(sql);
                lista=new ArrayList<>();
                while(res.next()){
                    Cancion c=new Cancion();
                    c.setNum(res.getInt("numCancion"));
                    c.setIdGrupo(res.getInt("grupo"));
                    c.setDuracion(res.getString("duracion"));
                    c.setTitulo(res.getString("titulo"));
                    c.setTotalVotos(res.getInt("total_votos"));
                    lista.add(c);
                }

            }
            catch (SQLException ex){
                lista=null;
            }
            try {
                if(res!=null)
                    res.close();
                if(st!=null)
                    st.close();
                if(con!=null)
                    con.close();
            } catch (SQLException e) {
            }
        }
        return lista;
    }

    public List<Grupo> cargarGrupos(){
        List<Grupo> lista;
        Connection con= Conexion.getConexion();
        if(con==null){
            return null;
        }
        else{
            Statement st=null;
            ResultSet res=null;
            String sql="SELECT codGrupo,nombre,localidad,estilo,annoGrab,fechaEstreno,compania, esGrupo" +
                    " FROM grupos";
            try {
                st = con.createStatement();
                res=st.executeQuery(sql);
                lista=new ArrayList<>();
                while(res.next()){
                    Grupo c=new Grupo();
                    c.setId(res.getInt("codGrupo"));
                    c.setNombre(res.getString("nombre"));
                    c.setLocalidad(res.getString("localidad"));
                    c.setEstilo(res.getString("estilo"));
                    c.setAnnoEstreno(res.getInt("annoGrab"));
                    c.setFechaGrab(res.getString("fechaEstreno"));
                    c.setComp(res.getString("compania"));
                    c.setEsgrupo(res.getBoolean("esgrupo"));
                    lista.add(c);
                }

            }
            catch (SQLException ex){
                lista=null;
            }
            try {
                if(res!=null)
                    res.close();
                if(st!=null)
                    st.close();
                if(con!=null)
                    con.close();
            } catch (SQLException e) {
            }
        }
        return lista;
    }

    public boolean updateCancion(Cancion cancion) {
        Connection con=Conexion.getConexion();
        if(con==null){
            System.err.println("Error, no ha conexion con la BD");
            return false;
        }
        boolean realizado=false;
        PreparedStatement prst=null;
        try {
            String sql="UPDATE canciones SET titulo=?, duracion=?,grupo=?,total_votos=? " +
                    "WHERE numCancion="+cancion.getNum();
            prst = con.prepareStatement(sql);
            prst.setString(1,cancion.getTitulo());
            prst.setString(2,cancion.getDuracion());
            prst.setInt(3,cancion.getIdGrupo());
            prst.setInt(4,cancion.getTotalVotos());
            prst.executeUpdate();
            //System.out.println("Se ha realizado correctamente la modificación");
            realizado=true;
        }
        catch (SQLException ex){
            //System.err.println("Error, no se ha podido hacer la modificación");
        }

        try {
            if (prst!=null)
                prst.close();
            if (con!=null)
                con.close();
        } catch (SQLException e) {
        }
        return realizado;
    }

    public boolean deleteCancion(Cancion c) {
        Connection con=Conexion.getConexion();
        if(con==null){
            System.err.println("Error, no ha conexion con la BD");
            return false;
        }
        boolean realizado=false;
        Statement st=null;
        try {
            String sql="DELETE FROM canciones WHERE numCancion="+c.getNum();
            st = con.createStatement();

            st.executeUpdate(sql);
            //System.out.println("Se ha realizado correctamente la modificación");
            realizado=true;
        }
        catch (SQLException ex){
            //System.err.println("Error, no se ha podido hacer la modificación");
        }

        try {
            if (st!=null)
                st.close();
            if (con!=null)
                con.close();
        } catch (SQLException e) {
        }
        return realizado;
    }

    public boolean insertCancion(Cancion cancion) {
        Connection con=Conexion.getConexion();
        if(con==null){
            System.err.println("Error, no ha conexion con la BD");
            return false;
        }
        boolean realizado=false;
        PreparedStatement prst=null;
        try {
            String sql="INSERT INTO canciones (titulo, duracion,grupo,total_votos) " +
                    "VALUES (?,?,?,?)";
            prst = con.prepareStatement(sql);
            prst.setString(1,cancion.getTitulo());
            prst.setString(2,cancion.getDuracion());
            prst.setInt(3,cancion.getIdGrupo());
            prst.setInt(4,cancion.getTotalVotos());
            prst.executeUpdate();

            realizado=true;
        }
        catch (SQLException ex){
            //System.err.println("Error, no se ha podido hacer la modificación");
        }

        try {
            if (prst!=null)
                prst.close();
            if (con!=null)
                con.close();
        } catch (SQLException e) {
        }
        return realizado;
    }
}
