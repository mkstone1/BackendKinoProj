package Backendkinoprojekt.configuration;

import Backendkinoprojekt.entity.Movie;
import Backendkinoprojekt.entity.Theater;
import Backendkinoprojekt.repository.MovieRepository;
import Backendkinoprojekt.repository.TheaterRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

@Controller
public class SetupDevData implements ApplicationRunner {


    MovieRepository movieRepository;
    TheaterRepository theaterRepository;

    public SetupDevData(MovieRepository movieRepository, TheaterRepository theaterRepository){
        this.movieRepository = movieRepository;
        this.theaterRepository = theaterRepository;
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



    }
}
