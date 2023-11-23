package dev.peter.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Planet {

    @Id
    @GeneratedValue
    private long id;
    private String name;

}
