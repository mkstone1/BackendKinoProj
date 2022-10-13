package Backendkinoprojekt.repository;

import Backendkinoprojekt.entity.Movie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    @BeforeAll
    public static void setUpData(@Autowired MovieRepository movieRepository) {
        Movie m1 = new Movie("Titanic", "Drama", 12, "Leonardo", 200);
        Movie m2 = new Movie("Remember", "Action", 14, "The Rock", 150);

        movieRepository.save(m1);
        movieRepository.save(m2);
    }

    /*@Test
    public void testGetAllMovies() {
        assertEquals(2, movieRepository.findAll().size());
    }*/

    /*@Test
    public void testGetMovieById() {
        assertEquals("Remember", movieRepository.findById(2).get().getName());
    }*/

    /*@Test
    public void testDeleteMovie() {
        Movie movieToBeDeleted = movieRepository.findById(1).orElseThrow();
        movieRepository.delete(movieToBeDeleted);

        assertEquals(1, movieRepository.findAll().size());
    }*/

    /*@Test
    public void testAddMovie() {
        Movie movieToBeAdded = new Movie("Pusher", "Crime", 16, "Mikkel", 140 );
        movieRepository.save(movieToBeAdded);
        assertEquals(3, movieRepository.findAll().size());
    }*/
}