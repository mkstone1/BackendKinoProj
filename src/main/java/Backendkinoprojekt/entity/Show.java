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
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int theaterId;
    private int movieId;
    private LocalDateTime showTime;

    private double price;

    @OneToMany(mappedBy = "show")
    private List<Ticket> tickets = new ArrayList<>();

    public Show(int theaterId, int movieId, LocalDateTime showTime, double price) {
        this.theaterId = theaterId;
        this.movieId = movieId;
        this.showTime = showTime;
        this.price = price;
    }

}
