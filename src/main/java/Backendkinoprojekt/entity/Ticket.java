package Backendkinoprojekt.entity;

import Backendkinoprojekt.dto.TicketDto;
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

    private int rowNumber;

    private int seatNumber;

    @ManyToOne()
    private Show show;

    public Ticket(int rowNumber, int seatNumber, Show show) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.show = show;
    }
}
