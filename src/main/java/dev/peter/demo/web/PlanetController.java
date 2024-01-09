package dev.peter.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.peter.demo.model.Planet;
import dev.peter.demo.repositories.PlanetRepository;

@RestController
@RequestMapping(value="/planet")
public class PlanetController {

    @Autowired
    private PlanetRepository planetRepository;

    @PostMapping
    private Planet createPlanet(@RequestBody Planet planet){
        return planetRepository.save(planet);
    }
    
}
