import java.sql.*;
import java.util.Scanner;

public class GestorConexion {

    private Connection con;

    public GestorConexion(Connection con) {
        this.con = con;
    }

    public boolean registrarUsuario(Usuario usu) {
        PreparedStatement st = null;
        boolean registrado = false;
        try {

            String sql = "INSERT INTO USUARIOS (nombre, apellidos, user, passwd, fechanac) " +
                    "VALUES(?,?,?,md5(?),?)";
            st = con.prepareStatement(sql);
            st.setString(1, usu.getNombre());
            st.setString(2, usu.getApellidos());
            st.setString(3, usu.getUser());
            st.setString(4, usu.getPasswd());
            st.setString(5, usu.getFechaNac().toString());
            int n = st.executeUpdate();
            if (n == 1) {
                System.out.println("Se ha registrado el usuario");
                registrado = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error en inserción de datos en base de datos");
            System.out.println("ERROR: " + ex.getErrorCode() + " - " + ex.getMessage());
            if (ex.getErrorCode() == 1062)
                System.err.println("ya existe un user con ese nombre de usuario");
        } finally {
            try {
                st.close();

            } catch (SQLException ex) {
                System.err.println("Se produjo un error en el cierrede recurso de AD");
            }
        }

        return registrado;
    }

    //Listado de grupos

    public void listGrupos() {
        try{
            PreparedStatement prepSt = con.prepareStatement("SELECT codgrupo,nombre,localidad,estilo FROM concursomusica.grupos order by codgrupo;");
            ResultSet rs = prepSt.executeQuery();
            System.out.println("codgrupo    nombre  localidad   estilo");
            while(rs.next()){
                Grupo grupo = new Grupo();
                grupo.setCodgrupo(rs.getInt(1));
                grupo.setNombre(rs.getString(2));
                grupo.setLocalidad(rs.getString(3));
                grupo.setEstilo(rs.getString(4));
                System.out.println(grupo.getCodgrupo()+"    "+grupo.getNombre()+"   "+grupo.getLocalidad()+"    "+grupo.getEstilo());
            }
        } catch (SQLException e) {
            System.out.println("Error en la frase SQL");
        }


    }

    public void listCanciones(){
        try{
            PreparedStatement prepSt = con.prepareStatement("SELECT g.nombre, c.titulo FROM grupos g INNER JOIN canciones c on c.grupo=g.codgrupo order by g.nombre;");
            ResultSet rs = prepSt.executeQuery();
            String grupo = "";
            while(rs.next()){
                if (!rs.getString(1).equalsIgnoreCase(grupo)){
                    grupo = rs.getString(1);
                    System.out.println(grupo);
                }

                System.out.println("    "+rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("Error en la frase SQL");
        }
    }

    public void countGrupoCanciones(){
        try{
            PreparedStatement prepSt = con.prepareStatement("SELECT g.nombre,COUNT(c.titulo)  FROM grupos g INNER JOIN canciones c on c.grupo=g.codgrupo group by g.nombre order by g.nombre;");
            ResultSet rs = prepSt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1)+": "+rs.getInt(2));
            }
        } catch (SQLException e) {
            System.out.println("Error en la frase SQL");
        }
    }

    public void cancionesPorGrupo(){
        Scanner entrada = new Scanner (System.in);
        System.out.println("Introduce el nombre del grupo:");
        String grupo = entrada.nextLine();
        try{
            PreparedStatement prepSt = con.prepareStatement("SELECT codgrupo FROM grupos where nombre = ? ;");
            prepSt.setString(1,grupo);
            ResultSet rs = prepSt.executeQuery();

            if (rs.next()){
                int numGrupo = rs.getInt(1);
                prepSt = con.prepareStatement("SELECT numCancion,titulo,duracion FROM canciones where grupo = ?");
                prepSt.setInt(1,numGrupo);
                rs = prepSt.executeQuery();
                while(rs.next()){
                    Cancion cancion = new Cancion();
                    cancion.setNumCancion(rs.getInt(1));
                    cancion.setTitulo(rs.getString(2));
                    cancion.setDuracion(rs.getString(3));
                    System.out.println(cancion.getNumCancion()+", "+cancion.getTitulo()+", "+cancion.getDuracion());
                }
            }else{
                System.out.println("El grupo no existe");
            }

        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
    public void masVotadas(){
        try{
            PreparedStatement prepSt = con.prepareStatement("SELECT canciones.titulo,grupos.nombre,canciones.total_votos FROM canciones LEFT JOIN grupos ON canciones.grupo=grupos.codgrupo order by canciones.total_votos desc limit 5");
            ResultSet rs = prepSt.executeQuery();
                while(rs.next()){
                    System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+rs.getInt(3));
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void gruposSinCanciones(){
        try{
            PreparedStatement prepSt = con.prepareStatement("SELECT g.nombre,COUNT(c.titulo)  FROM grupos g INNER JOIN canciones c on c.grupo=g.codgrupo group by g.nombre order by g.nombre;");
            ResultSet rs = prepSt.executeQuery();
            while(rs.next()){
                if (rs.getInt(2) == 0)
                System.out.println(rs.getString(1)+" no tiene canciones");
            }
        } catch (SQLException e) {
            System.out.println("Error en la frase SQL");
        }
    }

    public void ultimosVotos(){
        try{
            PreparedStatement prepSt = con.prepareStatement("SELECT v.usuario,v.fecha,c.titulo,g.nombre FROM votos v left join canciones c on v.cancion=c.numCancion left join grupos g on c.grupo=g.codgrupo order by v.fecha desc limit 5;");
            ResultSet rs = prepSt.executeQuery();
            while(rs.next()){

                    System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println("Error en la frase SQL");
        }
    }

    public void eliminarCanciones(){
        Scanner entrada = new Scanner (System.in);
        System.out.println("Introduce el nombre del grupo:");
        String grupo = entrada.nextLine();
        try{
            PreparedStatement prepSt = con.prepareStatement("SELECT codgrupo FROM grupos where nombre = ? ;");
            prepSt.setString(1,grupo);
            ResultSet rs = prepSt.executeQuery();

            if (rs.next()){
                int numGrupo = rs.getInt(1);
                prepSt = con.prepareStatement("SELECT numCancion FROM canciones where grupo = ?");
                prepSt.setInt(1,numGrupo);
                rs = prepSt.executeQuery();
                while(rs.next()){
                    PreparedStatement pre = con.prepareStatement("Delete ");
                    --------------------------
                            -------------------
                                    ------------------
                                            -´------------------------
                }
            }else{
                System.out.println("El grupo no existe");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

