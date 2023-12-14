package dev.peter.demo.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dev.peter.demo.model.Person;

@Repository
public interface PersonPagingRepository extends ListPagingAndSortingRepository<Person, Long> {

    List<Person> findAllBy(Pageable pageable);

    
} 
