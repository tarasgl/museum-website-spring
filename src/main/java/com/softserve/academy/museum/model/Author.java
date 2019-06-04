/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-409 group of Softserve Academy. (Andrii Vashchenok and Taras Hlukhovetskyi)
 *
 * Copyright (c) 1993-2019 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 *
 */
package com.softserve.academy.museum.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Pojo class for 'author' entity from database.
 *
 * @author Taras Hlukhovetskyi
 */
@Entity
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;


    /**
     * Gets id of an author.
     *
     * @return Integer id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id of an author.
     *
     * @param id Integer id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets first name of an author.
     *
     * @return First name of an author.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets first name of an author.
     *
     * @param firstname First name of an author.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets last name of an author.
     *
     * @return Last name of an author.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets last name of an author.
     *
     * @param lastname Last name of an author.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

    @Override
    public boolean equals(Object object) {

        if (object == this) {
            return true;
        } else if (!(object instanceof Author)) {
            return false;
        }

        Author author = (Author) object;

        return (author.firstname.equals(firstname))
                && (author.lastname.equals(lastname));
    }

}
