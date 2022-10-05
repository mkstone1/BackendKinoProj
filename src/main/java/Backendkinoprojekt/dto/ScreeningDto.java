package Backendkinoprojekt.dto;

import Backendkinoprojekt.entity.Screening;
import Backendkinoprojekt.entity.Theater;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScreeningDto {
    private int id;

    private String theaterName;
    private int movieId;
    private LocalDateTime screeningStartTime;
    private double price;

    public static Screening getScreeningEntity(ScreeningDto s , Theater theaterForScreening) {
        return new Screening(
                theaterForScreening,
                s.getMovieId(),
                s.screeningStartTime,
                s.getPrice()
        );
    }

    public ScreeningDto(Screening s, boolean includeAll) {
        this.theaterName = s.getTheater().getName();
        this.movieId = s.getMovieId();
        this.screeningStartTime = s.getScreeningStartTime();
        this.price = s.getPrice();
        if(includeAll) {
            this.id = s.getId();
        }
    }

    public ScreeningDto(Screening s){
        this.theaterName = s.getTheater().getName();
        this.movieId = s.getMovieId();
        this.screeningStartTime = s.getScreeningStartTime();
        this.price = s.getPrice();
    }

}
