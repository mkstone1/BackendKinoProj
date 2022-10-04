package Backendkinoprojekt.repository;

import Backendkinoprojekt.entity.Movie;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class TicketRepositoryTest {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;


    @BeforeAll
    public static void setUpData(@Autowired TicketRepository ticketRepository) {

    }


}