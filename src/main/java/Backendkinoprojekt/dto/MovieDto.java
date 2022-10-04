package Backendkinoprojekt.dto;


import Backendkinoprojekt.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private int id;
    private String name;
    private String genre;
    private int minAge;
    private String actors;

    private int runTime;


    public static Movie getMovieEntity(MovieDto m){
        return new Movie(m.getName(), m.getGenre(), m.getMinAge(), m.getActors(),m.getRunTime());
    }
    public MovieDto(Movie m, boolean includeAll){

        this.name = m.getName();
        this.genre = m.getGenre();
        this.minAge = m.getMinAge();
        this.actors = m.getActors();
        this.runTime = m.getRunTime();
        if(includeAll){
            this.id= m.getId();
        }
    }

    public MovieDto(Movie m){

        this.name = m.getName();
        this.genre = m.getGenre();
        this.minAge = m.getMinAge();
        this.actors = m.getActors();
        this.runTime = m.getRunTime();
}}
