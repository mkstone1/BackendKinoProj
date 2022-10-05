package Backendkinoprojekt.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "theater_row")
    private int rowNumber;

    @Column(name = "theater_seat")
    private int seatNumber;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "screening_id")
    private Screening screening;

    public Ticket(int rowNumber, int seatNumber, Screening screening) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.screening = screening;
    }
}
