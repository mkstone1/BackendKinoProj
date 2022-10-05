package Backendkinoprojekt.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Theater
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "theater_rows")
    private int rows;

    @Column(name = "theater_seats")
    private int seatsPrRow;

    public Theater(int rows, int seatsPrRow)
    {
        this.rows = rows;
        this.seatsPrRow = seatsPrRow;
    }
}
