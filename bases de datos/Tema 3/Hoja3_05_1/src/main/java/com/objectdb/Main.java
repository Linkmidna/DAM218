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
                a-	Obtener países por idioma
                b-	Obtener número de ciudades de cada país
                c-	Países por Hemisferio
                d-	Media de población ciudades de paises
                e-	Países con mayor media de población
                f-	Países con religión
                g-	Ciudades pobladas en países grandes
                h-	Países sin ciudades no capitales
                
                0-  salir
                                                
                """);
        return tec.nextLine();
    }
    private static void realiza(String op) {
        switch (op) {
            case "a"->listPaisesLanguage();
            case "b"->listNumCitiesPorPais();
            case "c"->listPorHemisferio();
            case "d"->mediaPoblacionPais();
            case "e"->paisesMayorMediaPoblacion();
            case "f"->paisesConReligion();
            case "g"->citiesPobladasPaisesGrandes();
            case "h"->paisesSinCiudadesNoCapitales();
        }
    }

    private static void paisesSinCiudadesNoCapitales() {
        Query query=em.createQuery("SELECT c FROM Country c LEFT JOIN c.cities city " +
                " GROUP BY c HAVING count(city)=0" );
        List<Country>  lista=query.getResultList();
        lista.forEach(c-> System.out.println(c.getName()));

    }

    private static void citiesPobladasPaisesGrandes() {
        Scanner tec=new Scanner(System.in);
        System.out.println("Introduce tamaño mínimo de los países em Km2");
        Double areaMin=tec.nextDouble();
        System.out.println("Introduce población mínima de las ciudades");
        Long popMin=tec.nextLong();
        Query query=em.createQuery("SELECT city FROM Country p " +
                "JOIN p.cities city WHERE p.area>:minA AND city.population>:minP");
        query.setParameter("minA",areaMin)
                .setParameter("minP",popMin);
        List<City> lista=query.getResultList();
        if(lista.isEmpty()){
            System.out.println("No hay ciudades que cumplan el criterios");
        }
        else{
            lista.forEach(c-> System.out.println(c.getName()+" - "+c.getPopulation()));
        }


    }

    private static void paisesConReligion() {
        System.out.println("Escribe la religión a buscar:");
        String rel=new Scanner(System.in).nextLine();
        //NO hay operadores o funciones para buscar en un Map
        Query query=em.createQuery("SELECT c FROM Country c");
        List<Country> lista=query.getResultList();

        lista.forEach(country -> {
            //Buscar rel en map
            //Pero diferencia may/min
            Float percent= country.getReligions().get(rel);
            if(percent!=null)
                    System.out.println(country.getName()+" - "+percent);
        });

    }

    private static void paisesConReligion2() {
        System.out.println("Escribe la religión a buscar:");
        String rel=new Scanner(System.in).nextLine();
        //NO hay operadores o funciones para buscar en un Map
        Query query=em.createQuery("SELECT c FROM Country c");
        List<Country> lista=query.getResultList();

        lista.forEach(country -> {

            country.getReligions().forEach((nomRel,percent)->{
                if(nomRel.equalsIgnoreCase(rel))
                    System.out.println(country.getName()+" - "+percent);
            });

        });

    }
    private static void paisesMayorMediaPoblacion() {
        Query query=em.createQuery("SELECT c.name,avg(city.population) FROM Country c " +
                "LEFT JOIN c.cities city GROUP BY c.name ORDER BY avg(city.population) DESC");
        List<Object[]>  lista=query.getResultList();
        for(int i=0;i<5;i++){
            System.out.println(lista.get(i)[0]+" - "+lista.get(i)[1]);
        }

    }

    private static void listPorHemisferio() {
        Query query=em.createQuery("SELECT c.coordinates.latitudeType,count(c.id),sum(c.population) " +
                "FROM Country c " +
                "GROUP BY c.coordinates.latitudeType");
        List<Object[]>  lista=query.getResultList();
        lista.forEach(object-> System.out.println(object[0]+" - "
                +object[1]+" paises  - "
                +object[2]+" habitantes"));
    }

    private static void mediaPoblacionPais() {
        System.out.println("Introduce nombre del pais");
        String pais=new Scanner(System.in).nextLine().toUpperCase();
        Query query=em.createQuery("SELECT avg(city.population) FROM Country c " +
                "INNER JOIN c.cities city WHERE upper(c.name)=:pais");
        query.setParameter("pais",pais);
        try{
            Double media=(Double)query.getSingleResult();
            if(media!=null)
                System.out.println("La media es "+media);
            else
                System.out.println("No hay datos del país");
        }
        catch (NoResultException ex){
            System.out.println("No hay datos del pais");
        }

    }
    private static void listNumCitiesPorPais() {
        Query query=em.createQuery("SELECT c.name,size(c.cities) FROM Country c " +
                "ORDER BY size(c.cities) DESC");
        List<Object[]>  lista=query.getResultList();
        lista.forEach(object-> System.out.println(object[0]+" - "+object[1]));
    }

    private static void listNumCitiesPorPais2() {
        Query query=em.createQuery("SELECT c.name,count(city) FROM Country c " +
                "LEFT JOIN c.cities city GROUP BY c.name ORDER BY count(city) DESC");
        List<Object[]>  lista=query.getResultList();
        lista.forEach(object-> System.out.println(object[0]+" - "+object[1]));
    }

    private static void listPaisesLanguage() {
        System.out.println("Escribe el idioma a buscar (primera letra en MAY):");
        String idioma=new Scanner(System.in).nextLine();
        Query query=em.createQuery("SELECT c FROM Country c WHERE :idioma in c.languages");
        query.setParameter("idioma",idioma);
        List<Country> lista=query.getResultList();
        if(lista.isEmpty())
            System.out.println("NO hay paises que cumplen el criterio");
        else {
            lista.forEach(country -> {
                System.out.println(country.getName());
                country.getLanguages().forEach(id-> System.out.println("\t"+id));
            });
        }
    }

}