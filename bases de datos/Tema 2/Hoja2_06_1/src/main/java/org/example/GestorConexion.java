package org.example;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GestorConexion {
    Scanner entrada = new Scanner(System.in);
    private Connection con;

    public GestorConexion(Connection con) {
        this.con = con;
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


}
