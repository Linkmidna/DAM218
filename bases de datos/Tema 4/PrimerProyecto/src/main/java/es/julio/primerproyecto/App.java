package es.julio.primerproyecto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.julio.primerproyecto.modelo.Alumno;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("PrimerProyecto");
        EntityManager em=emf.createEntityManager();
        
        Alumno alumno1=new Alumno(5,"ANA",6.5f);
        Alumno alumno2 = new Alumno(6,"BEATRIZ",7f);
        
        em.getTransaction().begin();
        em.persist(alumno1);
        em.persist(alumno2);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
