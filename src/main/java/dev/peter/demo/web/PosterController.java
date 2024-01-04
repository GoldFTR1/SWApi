package dev.peter.demo.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import dev.peter.demo.error.MissingFileException;
import dev.peter.demo.model.Poster;
import dev.peter.demo.repositories.PosterPaginationRepository;
import dev.peter.demo.repositories.PosterRepository;
import dev.peter.demo.web.dto.PersonPage;

@RestController
@RequestMapping(value = "/poster")
public class PosterController {
    
    @Autowired
    private PosterRepository posterRepository;
    
    @Autowired
    private PosterPaginationRepository posterPaginationRepository;

     @GetMapping(value="/person")
    private List<Poster> getAllPosters(){
        return (List<Poster>) posterRepository.findAll();
    }

    @GetMapping
    public PersonPage<Poster> getAllPosters(@RequestParam(required = false, defaultValue = "0") Integer page){


        Page<Poster> allPosters = posterPaginationRepository.findAll(PageRequest.of(page,10));

        return new PersonPage<>(allPosters);
    }


    @PostMapping(value = "")
    public Poster uploadPoster( 
        @RequestParam(name="poster", required = false) MultipartFile posterFile
    ) throws IOException{
        if(posterFile == null){
            throw new MissingFileException("poster", Poster.class.getName());
        }

        Poster poster = Poster.builder().content(posterFile.getBytes()).contentType(posterFile.getContentType()).build();

        return posterRepository.save(poster);

    }
}
