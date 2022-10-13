package Backendkinoprojekt.repository;

import Backendkinoprojekt.entity.Movie;
import Backendkinoprojekt.entity.Screening;
import Backendkinoprojekt.entity.Theater;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ScreeningRepositoryTest
{
    @Autowired
    ScreeningRepository screeningRepository;
    TheaterRepository theaterRepository;
    MovieRepository movieRepository;

    @BeforeAll
    public static void setUpData(@Autowired ScreeningRepository screeningRepository, @Autowired MovieRepository movieRepository, @Autowired TheaterRepository theaterRepository){
        Theater t1 = new Theater();
        Movie m1 = new Movie();
        LocalDateTime l1 = LocalDateTime.now();
        theaterRepository.save(t1);
        movieRepository.save(m1);

        Screening s1 = new Screening(t1, m1, l1, 200);
        Screening s2 = new Screening(t1, m1, l1, 200);
    }

    @Test
    void findAllByScreeningStartTimeBetween()
    {
    }

    /*@Test
    void findAllByTheater()
    {
        *//*Theater t1 = theaterRepository.findById(1);*//*
        assertEquals(2, screeningRepository.findAllByTheater(theaterRepository.findById(1).get()).size());
    }*/
}