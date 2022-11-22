package org.example;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class GestorConexion {
    Scanner entrada = new Scanner(System.in);
    private Connection con;
    private Connection con2;

    public GestorConexion(Connection con, Connection con2) {
        this.con = con;
        this.con2=con2;
    }

    public void crearCochesDB(){
        try {
            File f = new File("datos_coches.sql");
            BufferedReader br = new BufferedReader(new FileReader(f));

            String linea="";
            while((linea = br.readLine())!= null){
                Statement st=con.createStatement();
                st.executeUpdate(linea);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void crearCochesDBV2(){
        try {
            con.setAutoCommit(false);

            File f = new File("datos_coches.sql");
            BufferedReader br = new BufferedReader(new FileReader(f));

            String linea="";
            String script="";
            while((linea = br.readLine())!= null){
                script += linea;
            }
            Statement st=con.createStatement();
            st.executeUpdate(script);
            con.commit();
            con.setAutoCommit(true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearMunicipios(){
        try {
            con.setAutoCommit(false);

            Scanner entrada = new Scanner(System.in);
            System.out.println("Introduce la ruta del script (municipios.sql)");
            String ruta = entrada.nextLine();
            System.out.println("Introduce un nombre para la base de datos");
            String nombre = entrada.nextLine();




            File f = new File(ruta);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String linea="";
            String script="";
            script+="CREATE DATABASE "+nombre+";";
            script+="USE "+nombre+";";
            while((linea = br.readLine())!= null){
                script += linea;
            }
            Statement st=con.createStatement();
            st.executeUpdate(script);
            con.commit();
            con.setAutoCommit(true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void siguienteJornada(){
        try {
            String sql = "{call siguienteJornada(?)}";
            CallableStatement st = con2.prepareCall(sql);

            Statement stat=con2.createStatement();
            ResultSet rs = stat.executeQuery("SELECT numjornada FROM partidos ORDER BY numjornada DESC LIMIT 1;");
            rs.next();
            int numj = rs.getInt(1);

            if (numj > 18){
                System.out.println("Ya no hay mas jornadas");
            }
            else{
                st.setInt(1,numj);
                st.executeUpdate();

                rs = stat.executeQuery("SELECT numpartido,eqloc,eqvis,golesloc,golesvis,fecha FROM partidos where numjornada="+(numj+1));
                while (rs.next()){
                    System.out.println("Partido: "+rs.getString(1)+", Equipo local: "+rs.getString(2)+", Equpo visitante: "+rs.getString(3)+"Goles locales: "+rs.getString(4)+", Goles visitantes: "+rs.getString(5)+" y Fecha: "+rs.getString(6));
                }


            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
