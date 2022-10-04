package Backendkinoprojekt.service;

import Backendkinoprojekt.dto.TicketDto;
import Backendkinoprojekt.entity.Ticket;
import Backendkinoprojekt.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<TicketDto> getAllTickets() {
        return ticketRepository.findAll().stream().map((ticket) -> new TicketDto(ticket)).collect(Collectors.toList());
    }
}
