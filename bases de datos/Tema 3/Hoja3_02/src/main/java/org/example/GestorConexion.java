package org.example;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorConexion {
    Scanner entrada = new Scanner(System.in);
    private Connection con;
    private EntityManager em;

    public GestorConexion(Connection con, EntityManager em) {
        this.con = con;
        this.em = em;
    }

    public void AñadirGrupos(){
        try {
            List<Grupo> gruposA = new ArrayList<>();
            Statement stmt = con.createStatement();
            ResultSet hr = stmt.executeQuery("SELECT codgrupo,nombre,localidad,estilo,esgrupo,annoGrab FROM Grupos;");

            while (hr.next()) {

                Grupo grupo = new Grupo();
                grupo.setIdGrupo(hr.getInt(1));
                grupo.setNombre(hr.getString(2));
                grupo.setLocalidad(hr.getString(3));
                grupo.setEstilo(hr.getString(4));
                if (hr.getInt(5) == 1) {
                    grupo.setEsGrupo(true);
                } else {
                    grupo.setEsGrupo(false);
                }
                grupo.setYearFundacion(hr.getInt(6));
                gruposA.add(grupo);
            }

            Query qa = em.createQuery("SELECT e FROM Grupo e");
            List<Grupo> listaGrupoA = qa.getResultList();
            if (!listaGrupoA.isEmpty()){
                for(Grupo grupi: listaGrupoA){
                    em.getTransaction().begin();
                    em.remove(grupi);
                    em.getTransaction().commit();
                }
            }

            for (Grupo grupA : gruposA){
                em.getTransaction().begin();
                em.persist(grupA);
                em.getTransaction().commit();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void AñadirCanciones(){
        try {
            List<Cancion> cancionesB = new ArrayList<>();
            Statement stmt = con.createStatement();
            ResultSet hr = stmt.executeQuery("SELECT numCancion,titulo,duracion,grupo FROM canciones;");

            while (hr.next()) {

                Cancion cancion = new Cancion();
                cancion.setIdCancion(hr.getInt(1));
                cancion.setTitulo(hr.getString(2));
                cancion.setDuracion(hr.getString(3));
                cancion.setGrupo(em.find(Grupo.class,hr.getInt(4)));
                cancionesB.add(cancion);
            }
            Query qB = em.createQuery("SELECT e FROM Cancion e");
            List<Cancion> listaCancionB = qB.getResultList();
            if (!listaCancionB.isEmpty()) {
                for (Cancion can : listaCancionB) {
                    em.getTransaction().begin();
                    em.remove(can);
                    em.getTransaction().commit();
                }
            }

            for (Cancion canB : cancionesB) {
                em.getTransaction().begin();
                em.persist(canB);
                Grupo gb =em.find(Grupo.class,canB.getGrupo());
                gb.getCanciones().add(canB);
                em.persist(gb);
                em.getTransaction().commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void BuscarGrupo(){
        System.out.println("Introduce el nombre del grupo a buscar:");
        String nombreGrupo =entrada.nextLine();
        Query qc = em.createQuery("SELECT e FROM Grupo e WHERE e.nombre='"+nombreGrupo+"'");
        List<Grupo> listaC = qc.getResultList();
        if (!listaC.isEmpty()){
            Grupo gc = listaC.get(0);
            System.out.println(gc.toString());
            if (gc.getContacto()!=null){
                System.out.println(gc.getContacto().toString());
            }
            else{
                System.out.println("No hay información de contacto");
            }

            if(!gc.getCanciones().isEmpty()){
                gc.getCanciones().forEach(cancionC -> System.out.println(cancionC.toString()));
            }
            else{
                System.out.println("No tiene canciones asignadas");
            }
        }else{
            System.out.println("No existe ese grupo.");
        }
    }

    public void AñadirCancion(){
        System.out.println("Introduce el nombre del grupo a buscar:");
        String nombreGrupo =entrada.nextLine();
        Query qd = em.createQuery("SELECT e FROM Grupo e WHERE e.nombre='"+nombreGrupo+"'");
        List<Grupo> listaD = qd.getResultList();
        if (!listaD.isEmpty()){
            Grupo gd = listaD.get(0);
            System.out.println("Grupo existe");
            em.getTransaction().begin();
            Cancion canD = new Cancion();
            System.out.println("Introduce el titulo de la canción:");
            canD.setTitulo(entrada.nextLine());
            System.out.println("Introduce la duración de la canción:");
            canD.setDuracion(entrada.nextLine());
            canD.setGrupo(gd);

            Query queryd = em.createQuery("SELECT e FROM Grupo e");
            List<Grupo> CountD = queryd.getResultList();
            canD.setIdCancion(CountD.size()+1);

            em.persist(canD);

            gd.getCanciones().add(canD);
            em.persist(gd);

            em.getTransaction().commit();
            System.out.println("Canción añadida");
        }else{
            System.out.println("No existe ese grupo.");
        }
    }

    public void AsignarContacto(){
        System.out.println("Introduce el nombre del grupo a buscar:");
        String nombreGrupo =entrada.nextLine();
        Query qe = em.createQuery("SELECT e FROM Grupo e WHERE e.nombre='"+nombreGrupo+"'");
        List<Grupo> listaE = qe.getResultList();
        if (!listaE.isEmpty()){
            Grupo ge = listaE.get(0);
            System.out.println("Grupo existe");
            em.getTransaction().begin();

            Contacto ce = new Contacto();
            System.out.println("Introduce el email:");
            ce.setMail(entrada.nextLine());
            System.out.println("Introduce el Instagram:");
            ce.setInstagram(entrada.nextLine());
            System.out.println("Introduce el canal de youtube:");
            ce.setYoutube(entrada.nextLine());
            System.out.println("Introduce la dirección web:");
            ce.setWeb(entrada.nextLine());
            em.persist(ge);
            em.getTransaction().commit();
            System.out.println("Canción añadida");
        }else{
            System.out.println("No existe ese grupo.");
        }
    }

    public void BuscarCancion(){
        System.out.println("Introduce el id de la canción a buscar:");
        int idCancionG =entrada.nextInt();
        Cancion g = em.find(Cancion.class,idCancionG);
        if (g!=null){
            System.out.println(g.toString());
            System.out.println("Grupo: "+g.getGrupo().getNombre());
        }
    }

    public void ModificarCancion(){
        System.out.println("Introduce el id de la cancion a modificar:");
        int idCancionH =entrada.nextInt();
        entrada.nextLine();
        Cancion h = em.find(Cancion.class,idCancionH);
        if (h!=null){
            em.getTransaction().begin();
            System.out.println(h.toString());

            System.out.println("Introduce el id del nuevo grupo");
            int idGrupoH = entrada.nextInt();
            entrada.nextLine();

            Grupo grupoHNuevo = em.find(Grupo.class,idGrupoH);
            if (grupoHNuevo!=null){
                h.setGrupo(grupoHNuevo);
                em.persist(h);
                em.getTransaction().commit();
                System.out.println("Grupo modificado");
            }
            else{
                System.out.println("No existe ese grupo");
                em.getTransaction().rollback();
            }
        }
        else{
            System.out.println("Esa canción no existe");
        }
    }
}
