package dev.peter.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.peter.demo.model.Person;
import dev.peter.demo.repositories.PersonPagingRepository;
import dev.peter.demo.repositories.PersonRepository;


@RestController
public class PersonController {

    

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonPagingRepository personPagingRepository;

    @GetMapping(value="/person")
    private List<Person> getAllPerson(){
        return (List<Person>) personRepository.findAll();
    }

    @PostMapping(value = "/person")
    private Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }


}
