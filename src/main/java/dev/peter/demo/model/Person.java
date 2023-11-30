package dev.peter.demo.model;

import java.util.List;

import dev.peter.demo.constants.Gender;
import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Person {

    // @Id
    // @GeneratedValue
    // private long person_id;

    @Id 
    @GeneratedValue
    // @Column(name = "person_id")
    private Integer id;


    private String firstname;
    private String lastname;

    private Gender gender;
    
    @ManyToOne
    private Planet planet;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name ="Films", joinColumns =  @JoinColumn(name = "person_id"),
    inverseJoinColumns = @JoinColumn(name = "film_id"))
    private List<Film> films;


    
    
}
