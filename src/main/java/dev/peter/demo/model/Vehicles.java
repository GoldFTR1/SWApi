package dev.peter.demo.model;

// import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vehicles {

    @Id
    @GeneratedValue
    private Long id;

    private String vehicle_class;
    

    
}
