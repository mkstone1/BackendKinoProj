package Backendkinoprojekt.service;

import Backendkinoprojekt.dto.ScreeningDto;
import Backendkinoprojekt.entity.Screening;
import Backendkinoprojekt.repository.ScreeningRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScreeningService {

    private final ScreeningRepository screeningRepository;


    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
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
            Screening newScreening = screeningDto.getScreeningEntity(screeningDto);
            screeningRepository.save(newScreening);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editScreening(int screeningId, ScreeningDto screeningDto){
        try{
            Screening screeningFound = screeningRepository.findById(screeningId)
                    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Show not found"));
            screeningFound.setTheaterId(screeningDto.getTheaterId());
            screeningFound.setMovieId(screeningDto.getMovieId());
            screeningFound.setScreeningStartTime(LocalDateTime.parse(screeningDto.getScreeningStartTime()));
            screeningFound.setPrice(screeningDto.getPrice());
            screeningRepository.save(screeningFound);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
