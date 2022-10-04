package Backendkinoprojekt.dto;


import Backendkinoprojekt.entity.Movie;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDto {
    private int id;
    private String name;
    private String genre;
    private int minAge;
    private String actor;
    private int runTime;

    public MovieDto(Movie m, boolean includeAll){

        this.name = m.getName();
        this.genre = m.getGenre();
        this.minAge = m.getMinAge();
        this.actor = m.getActors();
        this.runTime = m.getRunTime();
        if(includeAll){
            this.id= m.getId();
        }
    }

}
