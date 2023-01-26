package com.objectdb.world;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class City {

    //--------------//
    // Data Members //
    //--------------//

    /** ID (Auto) */
    @Id
    @GeneratedValue
    private long id;

    /** nombre de la ciudad */
    private String name;

    /** Habitantes de la ciudad */
    private long population;

    /** Indica si una ciudad es capital de un país */
    private boolean capital;

    //------------//
    // Properties //
    //------------//

    // Name:

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Population:

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    // Capital:

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    //--------------//
    // Misc Methods //
    //--------------//

    /**
     * Gets a string representation of this.
     */
    @Override
    public String toString() {
        return name;
    }
}
