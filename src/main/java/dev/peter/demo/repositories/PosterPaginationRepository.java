package dev.peter.demo.repositories;


import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dev.peter.demo.model.Poster;

@Repository
public interface PosterPaginationRepository extends ListPagingAndSortingRepository<Poster, Long> {

    static List<Poster> findAllBy(Pageable pageable){

    throw new UnsupportedOperationException("Unimplemented method 'findAllBy'");
    }
} 