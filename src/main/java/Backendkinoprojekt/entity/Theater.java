package Backendkinoprojekt.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Theater
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "theater_rows")
    private int rows;

    @Column(name = "theater_seats")
    private int seatsPrRow;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.MERGE)
    List<Screening> screenings;

    public Theater(int rows, int seatsPrRow, String name)
    {
        this.rows = rows;
        this.seatsPrRow = seatsPrRow;
        this.name = name;
    }
}
