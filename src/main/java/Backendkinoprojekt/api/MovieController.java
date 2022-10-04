package Backendkinoprojekt.api;

import Backendkinoprojekt.dto.MovieDto;
import Backendkinoprojekt.service.MovieService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/movies")
@RestController
@CrossOrigin
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/{movieId}")
    MovieDto getMovieByID (@PathVariable int movieId){
        return movieService.getMovieById(movieId);
    }

}
