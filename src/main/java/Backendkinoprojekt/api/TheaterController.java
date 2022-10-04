package Backendkinoprojekt.api;

import Backendkinoprojekt.dto.TheaterResponse;
import Backendkinoprojekt.service.TheaterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/theaters")
@CrossOrigin
public class TheaterController
{
    TheaterService theaterService;

    public TheaterController(TheaterService theaterService){
        this.theaterService = theaterService;
    }

    @GetMapping(path = "/{id}")
    public TheaterResponse getTheaterById(@PathVariable int id) throws Exception{
        TheaterResponse theaterResponse = theaterService.getTheater(id);
        return theaterResponse;
    }
}
