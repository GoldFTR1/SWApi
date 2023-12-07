package dev.peter.demo.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import dev.peter.demo.error.MissingFileException;
import dev.peter.demo.model.Poster;
import dev.peter.demo.repositories.PosterRepository;

@RestController
@RequestMapping(value = "/poster")
public class PosterController {
    
    @Autowired
    private PosterRepository posterRepository;
    
    @PostMapping
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
