package dev.peter.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.peter.demo.model.Planet;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long>{
    
}
