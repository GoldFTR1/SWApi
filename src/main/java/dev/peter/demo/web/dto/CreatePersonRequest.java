package dev.peter.demo.web.dto;

import java.util.List;

import dev.peter.demo.constants.Gender;
import dev.peter.demo.model.Film;
import dev.peter.demo.model.Planet;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreatePersonRequest {

    @NotBlank
    private String firstName;
    @NotBlank

    private String lastName;
    private String gender;
    
    private Planet planet;

   
    private List<Long> films;
}
