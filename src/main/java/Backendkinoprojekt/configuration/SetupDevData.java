package Backendkinoprojekt.configuration;

import Backendkinoprojekt.entity.Movie;
import Backendkinoprojekt.repository.MovieRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

@Controller
public class SetupDevData implements ApplicationRunner {


    MovieRepository movieRepository;

    public SetupDevData(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Movie m1 = new Movie("Pirates", "Adventure", 13, "Johnny", 120);
        Movie m2 = new Movie("name", "genre", 10, "actor",140);

        movieRepository.save(m1);
        movieRepository.save(m2);





    }
}
