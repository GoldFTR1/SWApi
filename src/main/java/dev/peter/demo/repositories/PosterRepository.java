package dev.peter.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import dev.peter.demo.model.Poster;

@Repository
public interface PosterRepository extends CrudRepository<Poster, Long>{

    
    
}
