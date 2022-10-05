package Backendkinoprojekt.service;

import Backendkinoprojekt.dto.ScreeningDto;
import Backendkinoprojekt.entity.Movie;
import Backendkinoprojekt.entity.Screening;
import Backendkinoprojekt.entity.Theater;
import Backendkinoprojekt.repository.MovieRepository;
import Backendkinoprojekt.repository.ScreeningRepository;
import Backendkinoprojekt.repository.TheaterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScreeningService {

    private final ScreeningRepository screeningRepository;
    private final TheaterRepository theaterRepository;

    private final MovieRepository movieRepository;


    public ScreeningService(ScreeningRepository screeningRepository, TheaterRepository theaterRepository, MovieRepository movieRepository) {
        this.screeningRepository = screeningRepository;
        this.theaterRepository = theaterRepository;
        this.movieRepository = movieRepository;
    }

    public List<ScreeningDto> getAllScreenings(){
        return screeningRepository.findAll()
                .stream()
                .map(screening -> new ScreeningDto(screening,true))
                .collect(Collectors.toList());
    }

    public ScreeningDto getScreening(@PathVariable int id) throws Exception {
        Screening found = screeningRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "Screening with this id does not exist"
                        )
                );

        return new ScreeningDto(found, true);
    }

    public boolean addScreening(ScreeningDto screeningDto) {
        try {
            Movie movieForScreening = movieRepository.findById(screeningDto.getMovieId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Movie not found"));
            Theater theaterForScreening = theaterRepository.findById(screeningDto.getTheaterName()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Theater not found"));
            Screening newScreening = screeningDto.getScreeningEntity(screeningDto, theaterForScreening, movieForScreening);
            screeningRepository.save(newScreening);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editScreening(int screeningId, ScreeningDto screeningDto){
        try{
            Theater theaterForScreening = theaterRepository.findById(screeningDto.getTheaterName()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Theater not found"));
            Movie movieForScreening = movieRepository.findById(screeningDto.getMovieId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
            Screening screeningFound = screeningRepository.findById(screeningId)
                    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Show not found"));
            screeningFound.setTheater(theaterForScreening);
            screeningFound.setMovie(movieForScreening);
            screeningFound.setScreeningStartTime(screeningDto.getScreeningStartTime());
            screeningFound.setPrice(screeningDto.getPrice());
            screeningRepository.save(screeningFound);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
