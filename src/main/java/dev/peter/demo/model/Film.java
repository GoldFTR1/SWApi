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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Film {

    @Id
    @GeneratedValue
    private long id;
    private String title;

    @ManyToMany
    @JoinTable(name = "People_in_films", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "film__id"))
    private List<Person> people;

    @OneToOne(mappedBy = "film", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Poster poster;

}
