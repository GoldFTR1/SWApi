package dev.peter.demo.web.dto;

import org.springframework.data.domain.Page;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FilmPage<T> {


    public FilmPage(Page<T> FilmPage){
        
    }



    @Getter
    @Builder
    private static class PaginationMetadata{
        private final Integer currPage;
        private final Integer totalPage;
        private final Integer pageSize;
        private final Long totalElements;

    }
    
}
