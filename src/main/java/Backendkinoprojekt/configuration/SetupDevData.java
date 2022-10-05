package Backendkinoprojekt.configuration;

import Backendkinoprojekt.entity.Movie;
import Backendkinoprojekt.entity.Screening;
import Backendkinoprojekt.entity.Theater;
import Backendkinoprojekt.entity.Ticket;
import Backendkinoprojekt.repository.MovieRepository;
import Backendkinoprojekt.repository.ScreeningRepository;
import Backendkinoprojekt.repository.TheaterRepository;
import Backendkinoprojekt.repository.TicketRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class SetupDevData implements ApplicationRunner {


    MovieRepository movieRepository;
    TheaterRepository theaterRepository;
    TicketRepository ticketRepository;
    ScreeningRepository screeningRepository;

    public SetupDevData(MovieRepository movieRepository, TheaterRepository theaterRepository, TicketRepository ticketRepository, ScreeningRepository screeningRepository) {
        this.movieRepository = movieRepository;
        this.theaterRepository = theaterRepository;
        this.ticketRepository = ticketRepository;
        this.screeningRepository = screeningRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Movie m1 = new Movie("Pirates", "Adventure", 13, "Johnny", 120);
        Movie m2 = new Movie("name", "genre", 10, "actor",140);

        movieRepository.save(m1);
        movieRepository.save(m2);

        Theater t1 = new Theater(20, 12);
        Theater t2 = new Theater(25, 16);

        theaterRepository.save(t1);
        theaterRepository.save(t2);

        LocalDateTime ldt1 = LocalDateTime.of(2021, 10, 10, 10, 10);
        LocalDateTime ldt2 = LocalDateTime.of(2022, 11, 11, 11, 11);

        Screening s1 = new Screening(t1.getId(),m1.getId(),ldt1, 100);
        Screening s2 = new Screening(t2.getId(),m2.getId(),ldt2, 200);

        screeningRepository.save(s1);
        screeningRepository.save(s2);

        Ticket ticket1 = new Ticket(1, 1, s1);
        Ticket ticket2 = new Ticket(2, 3, s2);

        ticketRepository.save(ticket1);
        ticketRepository.save(ticket2);







    }
}
