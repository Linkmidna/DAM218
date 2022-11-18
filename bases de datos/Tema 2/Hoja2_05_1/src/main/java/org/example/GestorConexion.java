package org.example;

import java.sql.*;
import java.util.Scanner;

public class GestorConexion {
    Scanner entrada = new Scanner(System.in);
    private Connection con;

    public GestorConexion(Connection con) {
        this.con = con;
    }

    public void modificarVotos(){
        try{
            System.out.println("Introduce el numero del grupo:");
            int num = entrada.nextInt();

            PreparedStatement prepSt= con.prepareStatement("SELECT  numcancion,titulo,total_votos FROM canciones WHERE grupo=?", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            prepSt.setInt(1, num);
            ResultSet hr = prepSt.executeQuery();

            while (hr.next()){
                Cancion cancion = new Cancion();
                cancion.setNumCancion(hr.getInt(1));
                cancion.setTitulo(hr.getString(2));
                cancion.setTotal_votos(hr.getInt(3));
                System.out.println("Numero: "+cancion.getNumCancion()+"    Titulo: "+cancion.getTitulo()+"    Votos: "+cancion.getTotal_votos());
                System.out.println("¿Quieres añadir un voto? 1 Si / 2 No");
                int opc = entrada.nextInt();
                if (opc == 1){
                    hr.updateInt(3,cancion.getTotal_votos()+1);
                    hr.updateRow();
                    System.out.println("Aumentado en 1 :D");
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void gestionVotos(){
        try{
            Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet hr = stmt.executeQuery("SELECT usuario,fecha,cancion FROM votos ORDER BY fecha DESC LIMIT 10;");

            int pos = 1;
            while (hr.next()){

                Voto voto = new Voto();
                voto.setUsuario(hr.getString(1));
                voto.setFecha(hr.getString(2));
                voto.setCancion(hr.getInt(3));
                System.out.println("Usuario: "+voto.getUsuario()+"    Fecha: "+ voto.getFecha()+"    Cancion: "+voto.getCancion());
                System.out.println("1 Modificar usuario / 2 Eliminar voto / otro numero, No hacer nada");
                int opc = entrada.nextInt();
                if (opc == 1){
                    System.out.println("Introduce el nuevo nombre de usuario:");
                    entrada.nextLine();
                    String nom = entrada.nextLine();
                    hr.updateString(1,nom);
                    hr.updateRow();
                    System.out.println("Nuevo nombre: "+nom);
                    pos++;
                } else if (opc == 2) {
                    hr.deleteRow();
                    System.out.println("Voto eliminado");
                    hr.absolute(pos-1);
                }else{
                    pos++;
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void gestionVotosV2(){
        try{
            con.setAutoCommit(false);
            //Si quieres utilizar updateable querys en esta parte aunque no lo uses debes añadir en el select la primery key de la tabla que cambies Ej: el user en la linea 105
            //Pero aun asi en parte de este ejercicio no tienes por que usar una updateable query sino ejecutar un update sin mas ya que tienes los datos Ej: linea 123 y 127
            Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet hr = stmt.executeQuery("SELECT usuario,fecha,cancion FROM votos ORDER BY fecha DESC LIMIT 10;");

            int pos = 1;
            while (hr.next()){

                Voto voto = new Voto();
                voto.setUsuario(hr.getString(1));
                voto.setFecha(hr.getString(2));
                voto.setCancion(hr.getInt(3));
                System.out.println("Usuario: "+voto.getUsuario()+"    Fecha: "+ voto.getFecha()+"    Cancion: "+voto.getCancion());
                System.out.println("1 Modificar usuario / 2 Eliminar voto / otro numero, No hacer nada");
                int opc = entrada.nextInt();
                if (opc == 1){
                    System.out.println("Introduce el nuevo nombre de usuario:");
                    entrada.nextLine();
                    String nom = entrada.nextLine();
                    hr.updateString(1,nom);
                    hr.updateRow();
                    System.out.println("Nuevo nombre: "+nom);
                    pos++;

                    PreparedStatement prepSt1= con.prepareStatement("SELECT  numvotos,user FROM usuarios WHERE user=?", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    prepSt1.setString(1,voto.getUsuario());
                    ResultSet usr1 = prepSt1.executeQuery();
                    usr1.next();
                    usr1.updateInt(1,usr1.getInt(1)-1);

                    PreparedStatement prepSt2= con.prepareStatement("SELECT  numvotos,user FROM usuarios WHERE user=?", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    prepSt2.setString(1,nom);
                    ResultSet usr2 = prepSt2.executeQuery();
                    usr2.next();
                    usr2.updateInt(1,usr2.getInt(1)+1);

                    con.commit();
                } else if (opc == 2) {
                    hr.deleteRow();
                    System.out.println("Voto eliminado");
                    hr.absolute(pos-1);

                    PreparedStatement prepSt1= con.prepareStatement("UPDATE canciones SET total_votos = total_votos + 1 WHERE numCancion=?");
                    prepSt1.setInt(1,voto.getCancion());
                    prepSt1.executeUpdate();

                    PreparedStatement prepSt2= con.prepareStatement("UPDATE usuarios SET numvotos = numvotos + 1 WHERE user=?");
                    prepSt2.setString(1,voto.getUsuario());
                    prepSt2.executeUpdate();

                    con.commit();
                }else{
                    pos++;
                }
            }

            con.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
