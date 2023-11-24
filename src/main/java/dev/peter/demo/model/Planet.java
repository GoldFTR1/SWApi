package dev.peter.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Planet {

    @Id
    @GeneratedValue
    private long planet_id;
    private String name;

    @OneToMany(mappedBy = "planet")
    private List<Person> people;
}
