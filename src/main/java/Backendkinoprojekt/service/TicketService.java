package Backendkinoprojekt.service;

import Backendkinoprojekt.dto.TicketDto;
import Backendkinoprojekt.entity.Bruger;
import Backendkinoprojekt.entity.Screening;
import Backendkinoprojekt.entity.Ticket;
import Backendkinoprojekt.repository.ScreeningRepository;
import Backendkinoprojekt.repository.TicketRepository;
import Backendkinoprojekt.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    TicketRepository ticketRepository;
    ScreeningRepository screeningRepository;

    UserRepository userRepository;

    public TicketService(TicketRepository ticketRepository, ScreeningRepository screeningRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.screeningRepository = screeningRepository;
        this.userRepository = userRepository;
    }

    public List<TicketDto> getAllTickets() {
        return ticketRepository.findAll().stream().map((ticket) -> new TicketDto(ticket)).collect(Collectors.toList());
    }

    public TicketDto getTicketById(int ticketId) {
        Ticket foundTicket = ticketRepository.findById(ticketId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found"));
        return new TicketDto(foundTicket);
    }

    public boolean addTicket(TicketDto ticketDto) {
        try {
            Screening screeningForTicket = screeningRepository.findById(ticketDto.getScreeningId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Show not found"));
            Bruger brugerForTicket = userRepository.findBrugerByUsername(ticketDto.getUsername());
            Ticket ticketToBeAdded = ticketDto.getTicketEntity(ticketDto, screeningForTicket, brugerForTicket);
            ticketRepository.save(ticketToBeAdded);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteTicket(int ticketId) {
        try {
            Ticket ticketToBeDeleted = ticketRepository.findById(ticketId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found"));
            ticketRepository.delete(ticketToBeDeleted);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<TicketDto> getTicketsByScreeningId(int screeningId) {
        return ticketRepository.findAllByScreeningId(screeningId).stream().map((ticket) -> new TicketDto(ticket)).collect(Collectors.toList());
    }

    public List<TicketDto> getTicketsByBrugerUsername(String username) {
        return ticketRepository.findALlByBrugerUsername(username).stream().map((ticket) -> new TicketDto(ticket)).collect(Collectors.toList());
    }
}
