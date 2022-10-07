package Backendkinoprojekt.service;

import Backendkinoprojekt.dto.TheaterResponse;
import Backendkinoprojekt.entity.Theater;
import Backendkinoprojekt.repository.TheaterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheaterService
{
    private final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository){
        this.theaterRepository = theaterRepository;
    }

    public TheaterResponse getTheater(@PathVariable int id) throws Exception{
        Theater found = theaterRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Theater not found")
                );
        return new TheaterResponse(found);

    }

    public List<TheaterResponse> getAllTheaters() {
        return theaterRepository.findAll().stream().map(theater -> new TheaterResponse(theater)).collect(Collectors.toList());
    }
}
