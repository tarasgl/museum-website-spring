package com.softserve.academy.museum.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Pojo class for 'exhibit' entity from database.
 *
 * @author Andrii Vashchenok
 */
@Entity
@Table(name = "exhibit")
public class Exhibit {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Size(max = 45)
    private String name;

    @Column(name = "material")
    @Size(max = 45)
    private String material;

    @Column(name = "technique")
    @Size(max = 45)
    private String technique;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hall_id", referencedColumnName = "id")
    private Hall hall;

    @Column(name = "image")
    @Size(max = 255)
    private String image;


    /**
     * Gets id of an exhibit.
     *
     * @return Integer id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id of an exhibit.
     *
     * @param id Integer id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets material of an exhibit.
     *
     * @return String name of material.
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Sets material of an exhibit.
     *
     * @param material String with the name of material.
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Gets the name of technique.
     *
     * @return String with the name fo technique.
     */
    public String getTechnique() {
        return technique;
    }


    /**
     * Sets the name of technique.
     *
     * @param technique String with the name of technique.
     */
    public void setTechnique(String technique) {
        this.technique = technique;
    }

    /**
     * Gets the author of an exhibit.
     *
     * @return Author object.
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Sets the author of an exhibit.
     *
     * @param author Author object.
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * Gets the hall where exhibit is situated.
     *
     * @return Hall object.
     */
    public Hall getHall() {
        return hall;
    }

    /**
     * Sets the hall where exhibit is situated.
     *
     * @param hall Hall object.
     */
    public void setHall(Hall hall) {
        this.hall = hall;
    }

    /**
     * Gets the name of exhibit.
     *
     * @return String name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of an exhibit.
     *
     * @param name String name of an exhibit.
     */
    public void setName(String name) {
        this.name = name;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, technique, author, hall);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        } else if (!(object instanceof Exhibit)) {
            return false;
        }

        Exhibit exhibit = (Exhibit) object;

        return (exhibit.material.equals(material))
                && (exhibit.technique.equals(technique))
                && (exhibit.author.equals(author)
                && (exhibit.hall.equals(hall)));
    }

}

