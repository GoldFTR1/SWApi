package dev.peter.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.peter.demo.model.Film;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {

    // public List<Film> getAllFilms();
    
}
