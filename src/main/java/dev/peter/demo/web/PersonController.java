package dev.peter.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.peter.demo.mapper.PersonMapper;
import dev.peter.demo.model.Film;
import dev.peter.demo.model.Person;
import dev.peter.demo.repositories.FilmRepository;
import dev.peter.demo.repositories.PersonPagingRepository;
import dev.peter.demo.repositories.PersonRepository;
import dev.peter.demo.repositories.PlanetRepository;
import dev.peter.demo.service.ObjectValidator;
import dev.peter.demo.web.dto.CreatePersonRequest;
import dev.peter.demo.web.dto.PersonPage;
import jakarta.validation.constraints.Min;


@RestController
public class PersonController {

    private static final Integer PAGE_SIZE = 10;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonPagingRepository personPagingRepository;
    
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private ObjectValidator validator;

    // @GetMapping(value="/person")
    // private List<Person> getAllPerson(){
    //     return (List<Person>) personRepository.findAll();
    // }
    
    @GetMapping(value = "/person")
    @Validated
    private PersonPage<Person> getAllPeople(@RequestParam(required = false, defaultValue = "0") @Min(0) Integer page){
       PageRequest pageRequest  = PageRequest.of(page, PAGE_SIZE);

       return new PersonPage<>(personPagingRepository.findAll(pageRequest));
        

        
    }

    // @PostMapping(value = "/person")
    // private Person createPerson(@RequestBody Person person) {
    //     return personRepository.save(person);
    // }

    @PostMapping(value="/person")
    private ResponseEntity<Person> createPerson(@RequestBody CreatePersonRequest createPersonRequest){

        validator.validate(createPersonRequest);

        Person person = personMapper.personFromCreateRequest(createPersonRequest);

        if (createPersonRequest.getFilms() != null) {
            List<Film> films = (List<Film>) filmRepository.findAllById(createPersonRequest.getFilms());
            person.setFilms(films);
        }

        return ResponseEntity.status(201).body(personRepository.save(person));

    }

    


}
