package dev.peter.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.peter.demo.model.Vehicles;

@Repository
public interface VehiclesRepository extends CrudRepository<Vehicles, Long>{
    
}
