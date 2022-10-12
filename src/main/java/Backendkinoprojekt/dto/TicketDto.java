package Backendkinoprojekt.dto;

import Backendkinoprojekt.entity.Bruger;
import Backendkinoprojekt.entity.Screening;
import Backendkinoprojekt.entity.Ticket;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TicketDto {
    private int id;
    private int rowNumber;
    private int seatNumber;
    private int screeningId;

    private String username;

    public Ticket getTicketEntity(TicketDto t, Screening screening, Bruger bruger) {
        return new Ticket(t.getRowNumber(), t.getSeatNumber(), screening, bruger);
    }


    public TicketDto(Ticket t) {
        this.id = t.getId();
        this.rowNumber = t.getRowNumber();
        this.seatNumber = t.getSeatNumber();
        this.screeningId = t.getScreening().getId();
        this.username = t.getBruger().getUsername();
    }

}
