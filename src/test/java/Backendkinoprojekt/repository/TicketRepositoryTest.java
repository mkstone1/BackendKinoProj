package Backendkinoprojekt.repository;

import Backendkinoprojekt.entity.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TicketRepositoryTest
{
    @Autowired
    TicketRepository ticketRepository;
    ScreeningRepository screeningRepository;
    UserRepository userRepository;

    @BeforeAll
    public static void setUpData(@Autowired TicketRepository ticketRepository, @Autowired ScreeningRepository screeningRepository, @Autowired UserRepository userRepository){

        Screening s1 = new Screening();
        UserWithRoles u1 = new UserWithRoles("asd","asd","asd","asd","asd");
        userRepository.save(u1);
        screeningRepository.save(s1);
        Ticket t1 = new Ticket(1,2, s1, u1);
        Ticket t2 = new Ticket(1,3,s1,u1);


        ticketRepository.save(t1);
        ticketRepository.save(t2);
    }

    @Test
    void findAllByScreeningId()
    {
        assertEquals(2, ticketRepository.findAllByScreeningId(1).size());
    }

    @Test
    void findALlByUserWithRolesUsername()
    {
        assertEquals(2, ticketRepository.findALlByUserWithRolesUsername("asd").size());
    }
}