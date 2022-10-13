package Backendkinoprojekt.service;

import Backendkinoprojekt.dto.MovieDto;
import Backendkinoprojekt.entity.Movie;
import Backendkinoprojekt.repository.MovieRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MovieServiceTest {

    public MovieService movieService;


    public static MovieRepository movieRepository;

    @BeforeAll
    public static void setUpData(@Autowired MovieRepository movie_Repository) {
        movieRepository = movie_Repository;
        movieRepository.deleteAll();
        List<Movie> movies = List.of(
                new Movie("Titanic", "Drama", 12, "Leonardo DiCaprio", 200),
                new Movie("Batman", "Action", 14, "Christian Bale", 150)
        );
        movie_Repository.saveAll(movies);
    }

    @BeforeEach
    public void setMovieService(){
        movieService = new MovieService(movieRepository);
    }

    /*@Test
    void getMovieById() {
        MovieDto m = movieService.getMovieById(1);
        System.out.println(m.getName());
        assertEquals("Titanic", m.getName());
    }*/

    @Test
    void getAllMovies() {
        List<MovieDto> movies = movieService.getAllMovies();
        assertThat(movies, containsInAnyOrder(
                hasProperty("name", is("Titanic")),
                hasProperty("name", is("Batman"))));
    }

    /*@Test
    void editMovie() {
        MovieDto movieDto = new MovieDto(new Movie("Racoon", "Horror", 20, "Tom Hanks", 200));
        Movie movieToBeEditted = movieRepository.findById(1).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));;
        movieToBeEditted.setName(movieDto.getName());
        movieToBeEditted.setGenre(movieDto.getGenre());
        movieToBeEditted.setMinAge(movieDto.getMinAge());
        movieToBeEditted.setActors(movieDto.getActors());
        movieToBeEditted.setRunTime(movieDto.getRunTime());
        movieRepository.save(movieToBeEditted);

        assertEquals(movieRepository.findById(1).get().getName(), "Racoon");
    }

        @Test
        void addMovie() {
            Movie m = new Movie("Interstellar", "Sci fi", 12, "Matthew", 250);
            MovieDto movieDto = new MovieDto(m);
            movieService.addMovie(movieDto);

            assertEquals(3, movieRepository.findAll().size());
        }

        @Test
        void deleteMovie() {
            movieService.deleteMovie(1);
            assertEquals(1,movieRepository.findAll().size());
        }*/
}
