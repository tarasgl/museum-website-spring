package com.softserve.academy.museum.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="position")
public class Position {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

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
