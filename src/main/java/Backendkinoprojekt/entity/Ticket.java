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
@Table(name="billet")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="rækker-nummer", nullable = false)
    private int rowNumber;

    @Column(name="sædenummer", nullable = false)
    private int seatNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    private Show show;

    public Ticket(int rowNumber, int seatNumber, Show show) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.show = show;
    }
}
