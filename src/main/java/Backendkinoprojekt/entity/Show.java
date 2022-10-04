package Backendkinoprojekt.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private int theaterId;
    private int movieId;
    private LocalDateTime showTime;

    public Show(int theaterId, int movieId, LocalDateTime showTime) {
        this.theaterId = theaterId;
        this.movieId = movieId;
        this.showTime = showTime;
    }
}
