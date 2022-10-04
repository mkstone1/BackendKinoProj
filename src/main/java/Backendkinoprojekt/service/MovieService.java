package Backendkinoprojekt.service;

import Backendkinoprojekt.dto.MovieDto;
import Backendkinoprojekt.entity.Movie;
import Backendkinoprojekt.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MovieService {

    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public MovieDto getMovieById(int id){
        Movie foundMovie = movieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
        return new MovieDto(foundMovie, true);
    }
}
