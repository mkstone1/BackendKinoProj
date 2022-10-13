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

import java.time.LocalDate;
import java.time.LocalDateTime;
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
            Movie movieForScreening = movieRepository.findById(screeningDto.getMovieId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Movie not found"));
            Theater theaterForScreening = theaterRepository.findById(screeningDto.getTheaterId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Theater not found"));
            boolean isAvailable = checkAvailable(screeningDto, movieForScreening, theaterForScreening);
            if(isAvailable){
            Screening newScreening = screeningDto.getScreeningEntity(screeningDto, theaterForScreening, movieForScreening);
            screeningRepository.save(newScreening);
            return true;}
            else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Tidspunktet er allerede optaget");
            }
    }

    public boolean editScreening(int screeningId, ScreeningDto screeningDto){

            Theater theaterForScreening = theaterRepository.findById(screeningDto.getTheaterId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Theater not found"));
            Movie movieForScreening = movieRepository.findById(screeningDto.getMovieId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
            Screening screeningFound = screeningRepository.findById(screeningId)
                    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Show not found"));
            boolean isAvailable = checkAvailable(screeningDto, movieForScreening, theaterForScreening);
            if(isAvailable){
            screeningFound.setTheater(theaterForScreening);
            screeningFound.setMovie(movieForScreening);
            screeningFound.setScreeningStartTime(screeningDto.getScreeningStartTime());
            screeningFound.setPrice(screeningDto.getPrice());
            screeningRepository.save(screeningFound);
            return true;}
            else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Tidspunktet er allerede optaget");
            }

    }

    public List<ScreeningDto> getAllScreeningsToday(){
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime tomorrow = today.plusDays(1);
        LocalDateTime midnight = tomorrow.toLocalDate().atStartOfDay();

        List<Screening> screenings = screeningRepository.findAllByScreeningStartTimeBetween(today, midnight);
        return screenings.stream().map(screening -> new ScreeningDto(screening, true)).collect(Collectors.toList());
    }

    public List<ScreeningDto> getAllScreeningsFromSpecificDate(String date){
        LocalDate dateToSearch = LocalDate.parse(date);
        System.out.println(dateToSearch);
        LocalDateTime start = dateToSearch.atStartOfDay();
        LocalDateTime end = start.plusDays(1);

        List<Screening> screenings = screeningRepository.findAllByScreeningStartTimeBetween(start, end);
        return screenings.stream().map(screening -> new ScreeningDto(screening, true)).collect(Collectors.toList());
    }


    private boolean checkAvailable(ScreeningDto screeningDto, Movie movieForScreening, Theater theaterForScreening){
        LocalDateTime startTime = screeningDto.getScreeningStartTime();
        LocalDateTime endTime = screeningDto.getScreeningStartTime().plusMinutes(movieForScreening.getRunTime());
        List<Screening> screeningsOnDay = screeningRepository.findAllByTheater(theaterRepository.findById(screeningDto.getTheaterId()).orElseThrow());
        screeningsOnDay = screeningsOnDay.stream().filter(screening -> screening.getScreeningStartTime().toLocalDate().equals(startTime.toLocalDate())).collect(Collectors.toList());
        screeningsOnDay = screeningsOnDay.stream().filter(screening -> !screening.getEndTime().isBefore(startTime) && !screening.getScreeningStartTime().isAfter(endTime)).collect(Collectors.toList());
        if(screeningsOnDay.size()<1){
            return true;
        }
        else{
            return false;
        }
    }
}
