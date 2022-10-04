package Backendkinoprojekt.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Getter
@Setter
@Entity
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String genre;

    private int minAge;

    private String actors;

    private int runTime;

    public Movie(String name, String genre, int minAge, String actors, int runTime) {
        this.name = name;
        this.genre = genre;
        this.minAge = minAge;
        this.actors = actors;
        this.runTime = runTime;
    }
}
