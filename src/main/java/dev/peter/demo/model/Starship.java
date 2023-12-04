package dev.peter.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Starship {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(name="Starship_people", joinColumns = @JoinColumn(name="person_id"), inverseJoinColumns = @JoinColumn(name="starship_id"))
    private List<Person> listofpeople;

}
