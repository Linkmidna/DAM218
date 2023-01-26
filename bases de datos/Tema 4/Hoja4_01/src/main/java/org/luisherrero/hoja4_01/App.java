package org.luisherrero.hoja4_01;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.luisherrero.hoja4_01.modelo.Empleado;
import org.luisherrero.hoja4_01.modelo.Sueldo;


/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Hoja4_01");
        EntityManager em=emf.createEntityManager();
        
        //em.getTransaction().begin();
        
		/*
		 * Empleado emp1=new Empleado(); emp1.setId(1); emp1.setNombre("Luis Herrero");
		 * emp1.setOficio("Profesor"); emp1.setSalario(2000);
		 * emp1.setFechaAlta(LocalDate.of(1977,10,21));
		 * 
		 * Empleado emp2=new Empleado(); emp2.setId(2); emp2.setNombre("Ana Alonso");
		 * emp2.setOficio("Profesor"); emp2.setSalario(2000);
		 * emp2.setFechaAlta(LocalDate.of(1981,6,10));
		 */
        
		/*
		 * em.persist(emp1); em.persist(emp2);
		 */
        
        Scanner tec=new Scanner(System.in);
        
        Empleado empleado=new Empleado();
        System.out.println("Nombre y apellidos del empleado");
        empleado.setNombre(tec.nextLine());
        System.out.println("Oficio ?");
        empleado.setOficio(tec.nextLine());
        try {
        	System.out.println("Fecha de alta (aaaa-mm-dd) ?");
        	String text=tec.nextLine();
        	empleado.setFechaAlta(LocalDate.parse(text));
        	System.out.println("Introduce el salario");
        	double sal = tec.nextDouble();
        	System.out.println("Introduce la comisión");
        	double com = tec.nextDouble();
        	empleado.setSueldo(new Sueldo(sal,com));
        	em.getTransaction().begin();
        	em.persist(empleado);
        	em.getTransaction().commit();
        	System.out.println("Añadido el empleado");
        }
        catch(DateTimeParseException dtpe) {
        	System.err.println("Error, la fecha introducida es correcta");
        }
        catch(InputMismatchException eme) {
        	System.err.println("Error, no has introducido un valor numérico correcto");
        }
        
        em.close();
        emf.close();
    }
}
