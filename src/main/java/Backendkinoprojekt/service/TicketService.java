package Backendkinoprojekt.service;

import Backendkinoprojekt.dto.TicketDto;
import Backendkinoprojekt.entity.Screening;
import Backendkinoprojekt.entity.Ticket;
import Backendkinoprojekt.repository.ScreeningRepository;
import Backendkinoprojekt.repository.TicketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    TicketRepository ticketRepository;
    ScreeningRepository screeningRepository;

    public TicketService(TicketRepository ticketRepository, ScreeningRepository screeningRepository) {
        this.ticketRepository = ticketRepository;
        this.screeningRepository = screeningRepository;
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
            Screening showForTicket = screeningRepository.findById(ticketDto.getShowId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Show not found"));
            Ticket ticketToBeAdded = ticketDto.getTicketEntity(ticketDto, showForTicket);
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
}
