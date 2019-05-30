package com.softserve.academy.museum.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "excursion")
public class Excursion {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "start")
    private LocalDateTime start;

    @Column(name = "duration")
    private int duration;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
