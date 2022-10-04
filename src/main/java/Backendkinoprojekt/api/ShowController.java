package Backendkinoprojekt.api;

import Backendkinoprojekt.dto.ShowDto;
import Backendkinoprojekt.service.ShowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/shows")
@CrossOrigin
public class ShowController {

    ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping()
    public List<ShowDto> getAllShows(){
        return showService.getAllShows();
    }

    @GetMapping("/{id}")
    public ShowDto getShow(@PathVariable int id) throws Exception {
        return showService.getShow(id);
    }

    @PostMapping()
    public boolean addShow(@RequestBody ShowDto showDto) {
        return showService.addShow(showDto);
    }

    @PutMapping("/{showId}")
    public boolean editShow(@PathVariable int showId, @RequestBody ShowDto showDto) throws Exception {
        return showService.editShow(showId, showDto);
    }


}
