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
public class TheaterRequest
{
    int id;
    int rows;
    int seatsPrRow;

    public static Theater getTheaterEntity(TheaterRequest theaterRequest){
        return new Theater(
                theaterRequest.getRows(),
                theaterRequest.getSeatsPrRow()
        );
    }
}
