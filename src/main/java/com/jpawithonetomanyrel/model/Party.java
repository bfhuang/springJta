package com.jpawithonetomanyrel.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "parties")
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "party_id")
    private long id;

    private String location;

    @Column(name = "party_date")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date date;

    @ManyToMany

    @JoinTable(name = "people_parties",
            joinColumns = @JoinColumn(name = "party_id", referencedColumnName = "party_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"))
    private Set<Person> people = new HashSet<Person>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }


    // getters and setters
}