package dev.peter.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.peter.demo.constants.Gender;
import dev.peter.demo.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    public List<Person> findAllByGender(Gender gender);

    

    
} 