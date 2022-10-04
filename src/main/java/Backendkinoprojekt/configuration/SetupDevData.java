package Backendkinoprojekt.configuration;

import Backendkinoprojekt.entity.Movie;
import Backendkinoprojekt.entity.Show;
import Backendkinoprojekt.entity.Theater;
import Backendkinoprojekt.repository.MovieRepository;
import Backendkinoprojekt.repository.ShowRepository;
import Backendkinoprojekt.repository.TheaterRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class SetupDevData implements ApplicationRunner {


    MovieRepository movieRepository;
    TheaterRepository theaterRepository;

    ShowRepository showRepository;

    public SetupDevData(MovieRepository movieRepository, TheaterRepository theaterRepository, ShowRepository showRepository) {
        this.movieRepository = movieRepository;
        this.theaterRepository = theaterRepository;
        this.showRepository = showRepository;
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

        Show s1 = new Show(t1.getId(),m1.getId(),ldt1);
        Show s2 = new Show(t2.getId(),m2.getId(),ldt2);

        showRepository.save(s1);
        showRepository.save(s2);







    }
}
