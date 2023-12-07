package dev.peter.demo.repositories;

import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonPagingRepository extends ListPagingAndSortingRepository<Person, Long> {

    
} 
