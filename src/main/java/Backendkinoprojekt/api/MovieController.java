package Backendkinoprojekt.api;

import Backendkinoprojekt.dto.MovieDto;
import Backendkinoprojekt.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    List<MovieDto> getAllMovies (){
        return movieService.getAllMovies();
    }

    @PostMapping()
    boolean addMovie(@RequestBody MovieDto movieDto){
        return movieService.addMovie(movieDto);
    }

    @DeleteMapping("/{movieId}")
    boolean deleteMovie(@PathVariable int movieId) {
        return movieService.deleteMovie(movieId);
    }

}
