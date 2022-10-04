package Backendkinoprojekt.repository;

import Backendkinoprojekt.entity.Theater;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class TheaterRepositoryTest
{
    @Autowired
    TheaterRepository theaterRepository;

    @BeforeEach
    void setupBeforeEach(){
        Theater t1 = new Theater(15,15);
        Theater t2 = new Theater(19,15);
        Theater t3 = new Theater(20,15);
        Theater t4 = new Theater(35,15);

        theaterRepository.save(t1);
        theaterRepository.save(t2);
        theaterRepository.save(t3);
        theaterRepository.save(t4);
    }

    @Test
    void getTheaterById(){
        int id = 1;
        int expectedRows = 15;
        int expectedSeats = 15;

        Optional<Theater> t1 = theaterRepository.findById(id);
        Theater test = t1.get();

        assertEquals(test.getRows() , expectedRows);
        assertEquals(test.getSeatsPrRow(), expectedSeats);
    }

}
