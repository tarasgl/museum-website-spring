package com.softserve.academy.museum.model;

import javax.persistence.*;
import java.util.Objects;

/**
 *
 * Pojo class for 'position' database entity.
 *
 * @author Andrii Vashchenok
 * @version 1.0
 * @since 04.06.2019
 *
 */
@Entity
@Table(name="position")
public class Position {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    /**
     * Gets 'id' of the position.
     *
     * @return 'Id' of the position.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets 'id' of the position.
     *
     * @param id 'Id' of the position.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name of the position.
     *
     * @return Name of the position.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of the position.
     *
     * @param name Name of the position.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        } else if (!(object instanceof Position)) {
            return false;
        }

        Position position = (Position) object;

        return (position.name.equals(name));
    }

    @Override
    public String toString() {
        return name;
    }
}
