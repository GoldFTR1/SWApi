package dev.peter.demo.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private long person_id;
    private String firstname;
    private String lastname;

    @ManyToOne
    private Planet planet;

}
