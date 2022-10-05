package Backendkinoprojekt.dto;


import Backendkinoprojekt.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

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

    private List<Integer> screeningIds;
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
        this.screeningIds = m.getScreenings().stream().map(screening -> screening.getId()).collect(Collectors.toList());
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
