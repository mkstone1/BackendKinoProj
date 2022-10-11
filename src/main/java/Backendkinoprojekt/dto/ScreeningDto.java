package Backendkinoprojekt.dto;

import Backendkinoprojekt.entity.Movie;
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

    private int theaterId;
    private int movieId;
    private LocalDateTime screeningStartTime;

    private LocalDateTime endTime;
    private double price;

    public static Screening getScreeningEntity(ScreeningDto s , Theater theaterForScreening, Movie movieForScreening) {
        return new Screening(
                theaterForScreening,
                movieForScreening,
                s.screeningStartTime,
                s.getPrice()
        );
    }

    public ScreeningDto(Screening s, boolean includeAll) {
        this.theaterId = s.getTheater().getId();
        this.movieId = s.getMovie().getId();
        this.screeningStartTime = s.getScreeningStartTime();
        this.price = s.getPrice();
        this.endTime = s.getEndTime();
        if(includeAll) {
            this.id = s.getId();
        }
    }


}
