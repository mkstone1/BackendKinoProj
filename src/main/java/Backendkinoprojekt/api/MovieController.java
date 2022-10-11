package Backendkinoprojekt.api;

import Backendkinoprojekt.dto.MovieDto;
import Backendkinoprojekt.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("api/movies")
@RestController
@CrossOrigin
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{movieId}")
    MovieDto getMovieByID(@PathVariable int movieId) {
        return movieService.getMovieById(movieId);
    }

    @GetMapping()
    List<MovieDto> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping()
    boolean addMovie(@RequestBody MovieDto movieDto) {
        try {
            return movieService.addMovie(movieDto);
        }
        catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @DeleteMapping("/{movieId}")
    boolean deleteMovie(@PathVariable int movieId) {
        return movieService.deleteMovie(movieId);
    }

    @PutMapping("/{movieId}")
    boolean editMovie(@PathVariable int movieId, @RequestBody MovieDto movieDto) {
        return movieService.editMovie(movieId, movieDto);
    }
}
