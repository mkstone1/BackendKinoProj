package Backendkinoprojekt.dto;

import Backendkinoprojekt.entity.UserWithRoles;
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

    public Ticket getTicketEntity(TicketDto t, Screening screening, UserWithRoles userWithRoles) {
        return new Ticket(t.getRowNumber(), t.getSeatNumber(), screening, userWithRoles);
    }


    public TicketDto(Ticket t) {
        this.id = t.getId();
        this.rowNumber = t.getRowNumber();
        this.seatNumber = t.getSeatNumber();
        this.screeningId = t.getScreening().getId();
        this.username = t.getUserWithRoles().getUsername();
    }


}
