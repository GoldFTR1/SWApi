package dev.peter.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Film {

    @Id
    @GeneratedValue
    private long film_id;
    private String title;

    @ManyToMany
    @JoinTable(name = "People_in_films", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "film__id"))
    private List<Person> people;

    @OneToOne(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private Poster poster;

}
