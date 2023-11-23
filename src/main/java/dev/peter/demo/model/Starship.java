package dev.peter.demo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Starship {

    @Id
    @GeneratedValue
    private long id;
    private String name;

}
