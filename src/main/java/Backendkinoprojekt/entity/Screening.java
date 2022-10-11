package Backendkinoprojekt.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Theater theater;

    @ManyToOne
    private Movie movie;
    private LocalDateTime screeningStartTime;

    private double price;

    private LocalDateTime endTime;

    @OneToMany(mappedBy = "screening", cascade = CascadeType.MERGE)
    @Column(name = "screening_id")
    private List<Ticket> tickets = new ArrayList<>();

    private boolean isActive;
    public Screening(Theater theater, Movie movieId, LocalDateTime screeningStartTime, double price) {
        this.theater = theater;
        this.movie = movieId;
        this.screeningStartTime = screeningStartTime;
        this.price = price;
        this.endTime = screeningStartTime.plusMinutes(movieId.getRunTime()).plusMinutes(30);
    }

}
