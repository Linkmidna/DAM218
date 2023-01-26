package com.objectdb;

import com.objectdb.world.City;
import com.objectdb.world.Country;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static EntityManager em;
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "world.odb");
        em= emf.createEntityManager();
        String op;
        do {
            op = menu();
            realiza(op);
        } while (!op.equals("0"));
        if(em!=null)
            em.close();
        emf.close();
    }

    private static String menu() {
        Scanner tec = new Scanner(System.in);
        System.out.println("""
                   a-  Listar países
                    b-  Listar ciudades
                    c-  Listar ciudades países grandes
                    d-  Listar ciudades más pobladas
                    e-  Listar países limítrofes
                    f-  Listar países con más de 5 limítrofes
                    g-  Obtener capital de país
                    h-  Obtener número de países
                    i-  Obtener número de ciudades no capitales
                   
                    0-              salir
                """);
        return tec.nextLine();
    }
    private static void realiza(String op) {
        switch (op) {
            case "a"->listCountries();
            case "b"->listCities();
            case "c"->listCitiesPaisesGrandes();
            case "d"->listCitiesMasPobladas();
            case "e"->listPaisesLimitrofes();
            case "f"->listPaisesMasLimitrofes(5);
            case "g"->capitalPais();
            case "h"->numPaises();
            case "i"->numCiudadesNoCapitales();
        }
    }

    private static void numCiudadesNoCapitales() {
        Query query=em.createQuery("SELECT count(c.id) FROM City c WHERE  NOT c.capital");
        Long n=(Long) query.getSingleResult();
        System.out.println("Hay "+n+" ciudades no capitales almacenadas");
    }

    private static void numPaises() {
        Query query=em.createQuery("SELECT count(c.id) FROM Country c ");
        Long n=(Long) query.getSingleResult();
        System.out.println("Hay "+n+" países");
    }

    private static void capitalPais() {
        System.out.println("Nombre del país?");
        String pais=new Scanner(System.in).nextLine().toUpperCase();
        Query query=em.createQuery("SELECT c FROM Country c " +
                "WHERE upper(c.name)=:c");
        query.setParameter("c",pais);
        try{
            Country p=(Country) query.getSingleResult();
            System.out.print(p.getName()+" - ");
            City capital=p.getCapital();
            if(capital==null)
                System.out.println("No tiene capital");
            else
                System.out.println("Capital: "+capital.getName());

        }
        catch(NoResultException ex){
            System.out.println("No existe el pais");
        }
    }
    private static void listPaisesLanguage(String idioma) {
        Query query=em.createQuery("SELECT c FROM Country c WHERE :idioma in c.languages");
        query.setParameter("idioma",idioma);
        List<Country> lista=query.getResultList();
        if(lista.isEmpty())
            System.out.println("NO hay paises que cumplen el criterio");
        else {
            lista.forEach(country -> System.out.println(country.getName()));
        }
    }

    private static void listPaisesMasLimitrofes(int i) {

        Query query=em.createQuery("SELECT c FROM Country c WHERE size(c.neighbors) >:n");
        query.setParameter("n",i);
        List<Country> lista=query.getResultList();
        if(lista.isEmpty())
            System.out.println("NO hay paises que cumplen el criterio");
        else {
            lista.forEach(country -> System.out.println(country.getName()+" - "+
                country.getNeighbors().size()));
        }

    }
    private static void listPaisesMasCiudades(int i) {
        Query query=em.createQuery("SELECT c FROM Country c JOIN c.cities city WHERE size(c.cities) >:n");
        query.setParameter("n",i);
        List<Country> lista=query.getResultList();
        if(lista.isEmpty())
            System.out.println("NO hay paises que cumplen el criterio");
        else {
            lista.forEach(country -> System.out.println(country.getName()+" - "+
                    country.getCities().size()));
        }

    }
    private static void listPaisesLimitrofes() {
        System.out.println("Nombre del país?");
        String pais=new Scanner(System.in).nextLine().toUpperCase();
        Query query=em.createQuery("SELECT c FROM Country c " +
                "WHERE upper(c.name)=:c");
        query.setParameter("c",pais);
        try{
            Country p=(Country) query.getSingleResult();
            p.getNeighbors().forEach(x-> System.out.println(x.getName()));
        }
        catch(NoResultException ex){
            System.out.println("No existe el pais");
        }
    }

    private static void listCitiesMasPobladas() {
        System.out.println("Nombre de ciudad que marca el límite");
        String ciudad=new Scanner(System.in).nextLine().toUpperCase();
        Query query=em.createQuery("SELECT c FROM City c " +
                "WHERE upper(c.name)=:c");
        query.setParameter("c",ciudad);
        try{
            City city=(City) query.getSingleResult();
            Long pob=city.getPopulation();
            System.out.println("La población de "+ciudad+ " es "+pob+ " habitantes");
            System.out.println("CIUDADES CON MÁS HABITANTES QUE "+ciudad);
            query=em.createQuery("select c from City c where c.population>:p");
            query.setParameter("p",pob);
            List<City> ciudades=query.getResultList();
            ciudades.forEach(x-> System.out.println(x.getName()));
        }
        catch (NoResultException ex){
            System.out.println("No existe la ciudad "+ciudad);
        }

    }

    private static void listCitiesPaisesGrandes() {
        System.out.println("Introduce superficie mínima para países grandes");
        Double sup=new Scanner(System.in).nextDouble();
        Query query=em.createQuery("SELECT c FROM Country c " +
                "WHERE c.area>:sup ORDER BY c.area DESC");
        query.setParameter("sup",sup);
        List<Country> paises=query.getResultList();
        paises.forEach(p ->{
            for (City city : p.getCities()) {
                System.out.println(p.getName()+" -"+city.getName()+" - "+ city.getPopulation());
            }
        });
    }


    private static void listCities() {
        Query query=em.createQuery("SELECT c FROM City c ORDER BY c.name");
        List<City> cities=query.getResultList();
        cities.forEach(c -> System.out.println(
                c.getName()+" - "+c.getPopulation()+" - "
                + (c.isCapital()?"Es capital":"")

        ));
    }

    private static void listCountries() {
        Query query=em.createQuery("SELECT c FROM Country c ORDER BY c.name");
        List<Country> paises=query.getResultList();
        paises.forEach(c-> System.out.println(
                c.getId()+" - "+
                c.getName()+" - Hab: "+
                c.getPopulation()+" - Sup: "+
                c.getArea()+" - Hab/Km2: " +
                String.format("%.1f",c.getPopulation()/c.getArea())
        ));
    }
}