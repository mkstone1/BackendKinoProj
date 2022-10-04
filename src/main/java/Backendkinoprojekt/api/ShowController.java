package Backendkinoprojekt.api;

import Backendkinoprojekt.dto.ShowDto;
import Backendkinoprojekt.service.ShowService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/shows")
@CrossOrigin
public class ShowController {

    ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/{id}")
    public ShowDto getShow(@PathVariable int id) throws Exception {
        return showService.getShow(id);
    }

    @PostMapping()
    public boolean addShow(@RequestBody ShowDto showDto) {
        return showService.addShow(showDto);
    }


}
