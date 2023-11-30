package dev.peter.demo.repositories;

import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.peter.demo.model.Starship;

@Repository
public interface StarshipRepository extends CrudRepository<Starship, Long> {
    
}
