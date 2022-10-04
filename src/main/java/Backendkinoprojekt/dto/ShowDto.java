package Backendkinoprojekt.dto;

import Backendkinoprojekt.entity.Show;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowDto {
    private int id;
    private int theaterId;
    private int movieId;
    private LocalDateTime showTime;
    private double price;

    public static Show getShowEntity(ShowDto s) {
        return new Show(
                s.getTheaterId(),
                s.getMovieId(),
                s.getShowTime(),
                s.getPrice()
        );
    }

    public ShowDto(Show s, boolean includeAll) {
        this.theaterId = s.getTheaterId();
        this.movieId = s.getMovieId();
        this.showTime = s.getShowTime();
        this.price = s.getPrice();
        if(includeAll) {
            this.id = s.getId();
        }
    }

    public ShowDto(Show s){
        this.theaterId = s.getTheaterId();
        this.movieId = s.getMovieId();
        this.showTime = s.getShowTime();
        this.price = s.getPrice();
    }

}
