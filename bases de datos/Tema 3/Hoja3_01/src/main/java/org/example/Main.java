package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String opc;

        Connection con=Conexion.getConexion();

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory( "grupos.odb");
        EntityManager em= emf.createEntityManager();


        do {
            System.out.println("Introduce la opción que quieras:\n" +
                    "a- Añadir grupo\n" +
                    "b- Listar grupos\n" +
                    "c- Obtener grupo por Id\n" +
                    "d- Obtener grupo por nombre\n" +
                    "e- Añadir canción\n" +
                    "f- Listar canciones de grupo\n" +
                    "g- Listar canciones\n" +
                    "h- Modificar título de canción\n" +
                    "i- Modificar grupo de canción\n" +
                    "j- Eliminar canción\n" +
                    "k- Cargar datos en BD\n" +
                    "0- salir\n");
            opc= entrada.nextLine();

            switch (opc)
            {
                case "a":
                    em.getTransaction().begin();
                    Grupo a = new Grupo();
                    System.out.println("Introduce el nombre:");
                    a.setNombre(entrada.nextLine());
                    System.out.println("Introduce la localidad:");
                    a.setLocalidad(entrada.nextLine());
                    System.out.println("Introduce el estilo:");
                    a.setEstilo(entrada.nextLine());
                    System.out.println("Si es grupo escribe 1, si no lo es escribe 2");
                    if (entrada.nextInt()==1){
                        a.setEsGrupo(true);
                    }
                    else{
                        a.setEsGrupo(false);
                    }
                    System.out.println("Introduce el año de creación:");
                    a.setYearFundacion(entrada.nextInt());

                    em.persist(a);
                    em.getTransaction().commit();
                    break;
                case "b":
                    Query qb = em.createQuery("SELECT e FROM Grupo e");
                    List<Grupo> listaB = qb.getResultList();
                    listaB.forEach(grupo1 -> System.out.println(grupo1.toString()));
                    break;
                case "c":
                    System.out.println("Introduce el id del grupo a buscar:");
                    int idGrupoC =entrada.nextInt();
                    Grupo c = em.find(Grupo.class,idGrupoC);
                    if (c!=null){
                        System.out.println(c.toString());
                    }
                    break;
                case "d":
                    System.out.println("Introduce el nombre del grupo a buscar:");
                    String nombreGrupo =entrada.nextLine();
                    Query qd = em.createQuery("SELECT e FROM Grupo e WHERE e.nombre='"+nombreGrupo+"'");
                    List<Grupo> listaD = qd.getResultList();
                    listaD.forEach(grupo1 -> System.out.println(grupo1.toString()));
                    break;
                case "e":
                    System.out.println("Introduce el id del grupo al que pertenece la cancion:");
                    int idGrupoE =entrada.nextInt();
                    Grupo e = em.find(Grupo.class,idGrupoE);
                    if (e!=null){
                        System.out.println("Grupo: "+e.getNombre());
                        em.getTransaction().begin();
                        Cancion canE = new Cancion();
                        entrada.nextLine();
                        System.out.println("Introduce el titulo de la canción:");
                        canE.setTitulo(entrada.nextLine());
                        System.out.println("Introduce la duración de la canción:");
                        canE.setDuracion(entrada.nextLine());
                        canE.setGrupo(e.getIdGrupo());
                        em.persist(canE);
                        em.getTransaction().commit();
                        System.out.println("Canción añadida");
                    }
                    else{
                        System.out.println("El id de grupo introducido no existe.");
                        entrada.nextLine();
                    }
                    break;
                case "f":
                    System.out.println("Introduce el id del grupo a buscar:");
                    int idGrupoF =entrada.nextInt();
                    Grupo f = em.find(Grupo.class,idGrupoF);
                    if (f!=null){
                        System.out.println(f.toString());
                        Query qf = em.createQuery("SELECT c FROM Cancion c WHERE c.grupo="+idGrupoF);
                        List<Cancion> listaF = qf.getResultList();
                        listaF.forEach(cancion1 -> System.out.println(cancion1.toString()));
                    }
                    entrada.nextLine();
                    break;
                case "g":
                    Query qg = em.createQuery("SELECT c FROM Cancion c ORDER BY c.titulo asc");
                    List<Cancion> listaG = qg.getResultList();
                    for (Cancion canG : listaG){
                        Grupo g = em.find(Grupo.class, canG.getGrupo());
                        System.out.println(canG.toString()+", Nombre: "+g.getNombre());
                    }
                    break;
                case "h":
                    System.out.println("Introduce el id de la cancion a modificar:");
                    int idCancionH =entrada.nextInt();
                    entrada.nextLine();
                    Cancion h = em.find(Cancion.class,idCancionH);
                    if (h!=null){
                        em.getTransaction().begin();
                        System.out.println(h.toString());
                        System.out.println("Introduce la nueva duración");
                        h.setDuracion(entrada.nextLine());
                        em.getTransaction().commit();
                        System.out.println("Duración modificada");
                    }
                    else{
                        System.out.println("Esa canción no existe");
                    }
                    break;
                case "i":
                    System.out.println("Introduce el id de la cancion a modificar:");
                    int idCancionI =entrada.nextInt();
                    entrada.nextLine();
                    Cancion i = em.find(Cancion.class,idCancionI);
                    if (i!=null){
                        em.getTransaction().begin();
                        System.out.println(i.toString());

                        System.out.println("Introduce el nuevo grupo");
                        int idGrupoI = entrada.nextInt();
                        entrada.nextLine();

                        Grupo grupoI = em.find(Grupo.class,idGrupoI);
                        if (grupoI!=null){
                            i.setGrupo(idGrupoI);
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
                    break;
                case "j":
                    System.out.println("Introduce el id de la canción a eliminar:");
                    int idCancionJ =entrada.nextInt();
                    entrada.nextLine();
                    Cancion j = em.find(Cancion.class,idCancionJ);
                    if (j!=null){
                        System.out.println(j.toString());
                        System.out.println("Introduce 1 para eliminarla o 2 para mantenerla:");
                        if (entrada.nextInt()==1){
                            em.getTransaction().begin();
                            em.remove(j);
                            em.getTransaction().commit();
                            System.out.println("Canción eliminada");
                        }
                        else{
                            System.out.println("Canción no eliminada");
                        }
                    }
                    else{
                        System.out.println("Esa canción no existe");
                    }
                    break;
                case "k":
                    try {
                        List<Grupo> grupos = new ArrayList<>();
                        Statement stmt = con.createStatement();
                        ResultSet hr = stmt.executeQuery("SELECT codgrupo,nombre,localidad,estilo,esgrupo,annoGrab FROM Grupos;");

                        while (hr.next()) {

                            Grupo grupo = new Grupo();
                            grupo.setIdGrupo(hr.getInt(1));
                            grupo.setNombre(hr.getString(2));
                            grupo.setLocalidad(hr.getString(3));
                            grupo.setEstilo(hr.getString(4));
                            if (hr.getInt(5)==1){
                                grupo.setEsGrupo(true);
                            }
                            else{
                                grupo.setEsGrupo(false);
                            }
                            grupo.setYearFundacion(hr.getInt(6));
                            grupos.add(grupo);
                        }

                        List<Cancion> canciones = new ArrayList<>();
                        hr = stmt.executeQuery("SELECT numCancion,titulo,duracion,grupo FROM concursomusica.canciones;");

                        while (hr.next()) {

                            Cancion cancion = new Cancion();
                            cancion.setIdCancion(hr.getInt(1));
                            cancion.setTitulo(hr.getString(2));
                            cancion.setDuracion(hr.getString(3));
                            cancion.setGrupo(hr.getInt(4));
                            canciones.add(cancion);
                        }
                    }catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    Query qk = em.createQuery("SELECT e FROM Grupo e");
                    List<Grupo> listaK = qb.getResultList();
                    listaB.forEach(Grupo grupo:listaK);

                    break;
                case "0":
                    System.out.println("Gracias por utilizar nuestro programa");
                    em.close();
                    emf.close();
                    break;
                default:
                    System.out.println("Introduce una opción válida");
                    break;
            }

        }while(!opc.equalsIgnoreCase("0"));
    }

}