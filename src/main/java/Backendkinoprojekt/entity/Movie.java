package Backendkinoprojekt.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "movie_name")
    private String name;

    @Column(name = "movie_genre")
    private String genre;

    @Column(name = "movie_age")
    private int minAge;

    @Column(name = "movie_actors")
    private String actors;

    @Column(name = "movie_runtime")
    private int runTime;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.MERGE)
    List<Screening> screenings;

    public Movie(String name, String genre, int minAge, String actors, int runTime) {
        this.name = name;
        this.genre = genre;
        this.minAge = minAge;
        this.actors = actors;
        this.runTime = runTime;
    }
}
