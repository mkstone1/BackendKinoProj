package Backendkinoprojekt.api;

import Backendkinoprojekt.dto.ScreeningDto;
import Backendkinoprojekt.service.ScreeningService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/screenings")
@CrossOrigin
public class ScreeningController {

    ScreeningService screeningService;

    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @GetMapping()
    public List<ScreeningDto> getAllScreenings(){
        return screeningService.getAllScreenings();
    }

    @GetMapping("/{id}")
    public ScreeningDto getScreening(@PathVariable int id) throws Exception {
        return screeningService.getScreening(id);
    }

    @GetMapping("/date/{date}")
    public List<ScreeningDto> getAllScreeningsFromDate(@PathVariable String date) throws Exception{
        return screeningService.getAllScreeningsFromSpecificDate(date);
    }

    @PostMapping()
    public boolean addScreening(@RequestBody ScreeningDto screeningDto) {
        return screeningService.addScreening(screeningDto);
    }

    @PutMapping("/{screeningId}")
    public boolean editScreening(@PathVariable int screeningId, @RequestBody ScreeningDto screeningDto) throws Exception {
        return screeningService.editScreening(screeningId, screeningDto);
    }

    @GetMapping("/today")
    public List<ScreeningDto> getScreeningsToday(){
        return screeningService.getAllScreeningsToday();
    }


}
