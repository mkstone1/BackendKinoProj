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

    private int theaterId;
    private int movieId;
    private LocalDateTime screeningStartTime;

    private double price;

    @OneToMany(mappedBy = "screening", cascade = CascadeType.MERGE)
    @Column(name = "screening_id")
    private List<Ticket> tickets = new ArrayList<>();

    public Screening(int theaterId, int movieId, LocalDateTime screeningStartTime, double price) {
        this.theaterId = theaterId;
        this.movieId = movieId;
        this.screeningStartTime = screeningStartTime;
        this.price = price;
    }

}
