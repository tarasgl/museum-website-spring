/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-409 group of Softserve Academy. (Andrii Vashchenok and Taras Hlukhovetskiy)
 *
 * Copyright (c) 1993-2019 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 *
 */
package com.softserve.academy.museum.model;

import javax.persistence.*;
import java.util.Objects;

/**
 *
 * Pojo class for 'employee' database entity.
 *
 * @author Andrii Vashchenok
 * @version 1.0
 * @since 04.06.2019
 *
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position", referencedColumnName = "id")
    private Position position;

    @Column(name = "image")
    private String image;


    /**
     * Gets id of an employee.
     *
     * @return Integer id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id of an employee.
     *
     * @param id Integer id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets first name of an employee.
     *
     * @return First name of an employee.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets first name of an employee.
     *
     * @param firstname First name of an employee.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets last name of an employee.
     *
     * @return Last name of an employee.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets last name of an employee.
     *
     * @param lastname Last name of an employee.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets position of an employee.
     *
     * @return Enum with position of an employee.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets position of an employee.
     *
     * @param position Enum with position of an employee.
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Gets the image path for the employee.
     *
     * @return Path for image.
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the image path for the employee.
     *
     * @param image Path for image.
     */
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, position);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        } else if (!(object instanceof Employee)) {
            return false;
        }

        Employee employee = (Employee) object;

        return (employee.firstname.equals(firstname))
                && (employee.lastname.equals(lastname))
                && (employee.position.equals(position));
    }

}
