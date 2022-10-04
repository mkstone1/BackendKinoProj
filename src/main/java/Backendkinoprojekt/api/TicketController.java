package Backendkinoprojekt.api;

import Backendkinoprojekt.dto.TicketDto;
import Backendkinoprojekt.service.TicketService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/tickets")
@RestController
@CrossOrigin
public class TicketController {

    TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping()
    public List<TicketDto> getAllTickets() {
        return ticketService.getAllTickets();
    }
}
