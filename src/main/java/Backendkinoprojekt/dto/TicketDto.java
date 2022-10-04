package Backendkinoprojekt.dto;

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

    public Ticket getTicketEntity(TicketDto t) {
        return new Ticket(t.getRowNumber(), t.getSeatNumber());
    }

    public TicketDto(Ticket t) {
        this.id = t.getId();
        this.rowNumber = t.getRowNumber();
        this.seatNumber = t.getSeatNumber();
    }

}
