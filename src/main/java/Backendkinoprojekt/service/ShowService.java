package Backendkinoprojekt.service;

import Backendkinoprojekt.dto.ShowDto;
import Backendkinoprojekt.entity.Show;
import Backendkinoprojekt.repository.ShowRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowService {

    private final ShowRepository showRepository;


    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public List<ShowDto> getAllShows(){
        return showRepository.findAll()
                .stream()
                .map(show -> new ShowDto(show,true))
                .collect(Collectors.toList());
    }

    public ShowDto getShow(@PathVariable int id) throws Exception {
        Show found = showRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "Show with this id does not exist"
                        )
                );

        return new ShowDto(found, true);
    }

    public boolean addShow(ShowDto showDto) {
        try {
            Show newShow = showDto.getShowEntity(showDto);
            showRepository.save(newShow);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editShow(int showId, ShowDto showDto){
        try{
            Show showFound = showRepository.findById(showId)
                    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Show not found"));
            showFound.setTheaterId(showDto.getTheaterId());
            showFound.setMovieId(showDto.getMovieId());
            showFound.setShowTime(showDto.getShowTime());
            showFound.setPrice(showDto.getPrice());
            showRepository.save(showFound);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
