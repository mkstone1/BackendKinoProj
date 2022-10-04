package Backendkinoprojekt.service;

import Backendkinoprojekt.dto.MovieDto;
import Backendkinoprojekt.entity.Movie;
import Backendkinoprojekt.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public MovieDto getMovieById(int movieId){
        Movie foundMovie = movieRepository.findById(movieId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
        return new MovieDto(foundMovie, true);
    }

    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll().stream().map(movie -> new MovieDto(movie,true)).collect(Collectors.toList());
    }

    public boolean addMovie(MovieDto movieDto) {
       try {
           Movie newMovie = movieDto.getMovieEntity(movieDto);
           movieRepository.save(newMovie);
           return true;
       }
       catch (Exception e){
           return false;
       }
    }

    public boolean deleteMovie(int id) {
        try {
            Movie movieFound = movieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
            movieRepository.delete(movieFound);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editMovie(int movieId, MovieDto movieDto) {
        try {
            Movie movieFound = movieRepository.findById(movieId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
            movieFound.setName(movieDto.getName());
            movieFound.setGenre(movieDto.getGenre());
            movieFound.setMinAge(movieDto.getMinAge());
            movieFound.setActors(movieDto.getActors());
            movieFound.setRunTime(movieDto.getRunTime());
            movieRepository.save(movieFound);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
