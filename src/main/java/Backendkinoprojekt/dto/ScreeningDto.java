package Backendkinoprojekt.dto;

import Backendkinoprojekt.entity.Screening;
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
    private int theaterId;
    private int movieId;
    private String screeningStartTime;
    private double price;

    public static Screening getScreeningEntity(ScreeningDto s) {
        return new Screening(
                s.getTheaterId(),
                s.getMovieId(),
                LocalDateTime.parse(s.screeningStartTime),
                s.getPrice()
        );
    }

    public ScreeningDto(Screening s, boolean includeAll) {
        this.theaterId = s.getTheaterId();
        this.movieId = s.getMovieId();
        this.screeningStartTime = s.getScreeningStartTime().toString();
        this.price = s.getPrice();
        if(includeAll) {
            this.id = s.getId();
        }
    }

    public ScreeningDto(Screening s){
        this.theaterId = s.getTheaterId();
        this.movieId = s.getMovieId();
        this.screeningStartTime = s.getScreeningStartTime().toString();
        this.price = s.getPrice();
    }

}
