package Backendkinoprojekt.service;

import Backendkinoprojekt.dto.ShowDto;
import Backendkinoprojekt.entity.Show;
import Backendkinoprojekt.repository.ShowRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ShowService {

    private final ShowRepository showRepository;


    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
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

        return new ShowDto(found, false);
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

}
