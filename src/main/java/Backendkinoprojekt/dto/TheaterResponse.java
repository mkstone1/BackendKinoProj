package Backendkinoprojekt.dto;

import Backendkinoprojekt.entity.Theater;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TheaterResponse
{
    int id;
    int rows;
    int seatsPrRow;

    String name;

    public TheaterResponse(Theater theater){
        this.id  = theater.getId();
        this.rows = theater.getRows();
        this.seatsPrRow = theater.getSeatsPrRow();
        this.name = theater.getName();
    }
}
