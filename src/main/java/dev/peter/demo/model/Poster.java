package dev.peter.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class Poster {

    @Id
    @GeneratedValue
    private long id;

    private byte[] content;

    private String contentType;

      @OneToOne
    @JoinColumn(name = "film_id", unique = true)
    private Film film;
    
}
