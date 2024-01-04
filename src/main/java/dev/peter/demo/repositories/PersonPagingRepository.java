package dev.peter.demo.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dev.peter.demo.model.Person;

@Repository
public interface PersonPagingRepository extends ListPagingAndSortingRepository<Person, Long> {

    static List<Person> findAllBy(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllBy'");
    }

    
} 
