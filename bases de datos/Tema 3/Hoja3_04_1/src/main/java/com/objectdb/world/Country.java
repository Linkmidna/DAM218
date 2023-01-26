package com.objectdb.world;

import javax.persistence.*;
import java.util.*;

@Entity
public class Country implements Comparable<Country> {

    //--------------//
    // Data Members //
    //--------------//

    /** ID (CIA WFB country code) */
    @Id
    private String id;

    /** nombre corto del país (nombre normal) */
    private String name;

    /** denominación completa del país */
    private String fullName;

    /** Descripción general */
    private String background;

    /** Descripción de la localización */
    private String location;

    /** Coordenadas de geolocalización */
    @Embedded
    private Coordinates coordinates;

    /** Superficie en Km cuadrados */
    private double area;

    /** Países limítrofes */
    private Set<Country> neighbors;

    /** KIlometros de Costa */
    private int coastline;

    /** Population size */
    private long population;

    /** Population growth - percentage per year */
    private Double populationGrowth;

    /** Religions to percentage in population */
    @ElementCollection
    private Map<String,Float> religions;

    /** Official or common languages */
    @ElementCollection(fetch=FetchType.EAGER)
    private List<String> languages;

    /** Notable cities */
    @OneToMany(cascade=CascadeType.PERSIST)
    private List<City> cities;

    /** Capital city */
    @OneToOne(cascade=CascadeType.PERSIST)
    private City capital;

    /** GDP details */
    @Embedded
    private GDP gdp;

    /** Unemployment percentage */
    private Float unemployment;

    //------------//
    // Properties //
    //------------//

    // Id:

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    // Name:

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!"none".equalsIgnoreCase(name)) {
            this.name = name;
            if (this.fullName == null) {
                this.fullName = name;
            }
        }
    }

    // Full Name:

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (!"none".equalsIgnoreCase(fullName)) {
            this.fullName = fullName;
            if (this.name == null) {
                this.name = fullName;
            }
        }
    }

    // Background:

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    // Location:

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Coordinates:

    public Coordinates getCoordinates() {
        if (coordinates == null)
            coordinates = new Coordinates();
        return coordinates;
    }

    // Area:

    public void setArea(double area) {
        this.area = Math.max(0, area);
    }

    public double getArea() {
        return area;
    }

       public Set<Country> getNeighbors() {
        if (neighbors == null)
            neighbors = new TreeSet<Country>();
        return neighbors;
    }

    // Coastline:

    public int getCoastline() {
        return coastline;
    }

    public void setCoastline(int coastline) {
        this.coastline = Math.max(0, coastline);
    }

    // Population:

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = Math.max(0, population);
    }

    // Population Growth:

    public Double getPopulationGrowth() {
        return populationGrowth;
    }

    public void setPopulationGrowth(double populationGrowth) {
        if (populationGrowth != -1) {
            this.populationGrowth = Double.valueOf(populationGrowth);
        }
    }

    // Religions:

    public Map<String, Float> getReligions() {
        if (religions == null)
            religions = new TreeMap<String, Float>();
        return religions;
    }

    // Languages:

    public List<String> getLanguages() {
        if (languages == null)
            languages = new ArrayList<String>(4);
        return languages;
    }

    // Cities:

    public List<City> getCities() {
        if (cities == null)
            cities = new ArrayList<City>(4);
        return cities;
    }

    // Capital:

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    // GDP:

    public GDP getGdp() {
        if (gdp == null)
            gdp = new GDP();
        return gdp;
    }

    // Unemployment:

    public Float getUnemployment() {
        return unemployment;
    }

    public void setUnemployment(float unemployment) {
        if (unemployment != -1) {
            this.unemployment = Float.valueOf(unemployment);
        }
    }

    //--------------//
    // Misc Methods //
    //--------------//

    /**
     * Compares this to another Country (by name) for order in neighbors.
     */
    public int compareTo(Country o) {
        return name.compareTo(o.name);
    }

    /**
     * Gets a string representation of this.
     */
    @Override
    public String toString() {
        return name;
    }
}
