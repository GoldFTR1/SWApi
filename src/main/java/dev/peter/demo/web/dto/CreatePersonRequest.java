package dev.peter.demo.web.dto;

import java.util.List;

import dev.peter.demo.constants.Gender;
import dev.peter.demo.model.Film;
import dev.peter.demo.model.Planet;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CreatePersonRequest {

    private String firstName;

    private String lastName;
    private String gender;
    
    private Planet planet;

   
    private List<Film> films;
}
