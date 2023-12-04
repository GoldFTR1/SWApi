package dev.peter.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.peter.demo.model.Film;
import dev.peter.demo.model.Person;
import dev.peter.demo.repositories.FilmRepository;

@RestController
@RequestMapping(value="/film")
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping
    public List<Film> getAllFilms(){

       return (List<Film>) filmRepository.findAll();
    }

    @PostMapping
    private Film createFilm(@RequestBody Film film) {
        return filmRepository.save(film);
    }

    
    
}
