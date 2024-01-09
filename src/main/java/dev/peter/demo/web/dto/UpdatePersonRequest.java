package dev.peter.demo.web.dto;

import java.util.List;

import dev.peter.demo.constants.Gender;
import dev.peter.demo.model.Planet;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePersonRequest {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    private Gender gender;
    
    private List<Long> filmIds;

    private Planet planet;


    
    
}
