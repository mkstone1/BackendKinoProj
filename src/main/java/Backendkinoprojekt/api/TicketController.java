package Backendkinoprojekt.api;

import Backendkinoprojekt.dto.TicketDto;
import Backendkinoprojekt.service.TicketService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{ticketId}")
    public TicketDto getTicketById(@PathVariable int ticketId) {
        return ticketService.getTicketById(ticketId);
    }

    @PostMapping()
    public boolean addTicket(@RequestBody TicketDto ticketDto) {
        return ticketService.addTicket(ticketDto);
    }

    @DeleteMapping("/{ticketId}")
    public boolean deleteTicket(@PathVariable int ticketId) {
        return ticketService.deleteTicket(ticketId);
    }

    @GetMapping("/screening/{screeningId}")
    public List<TicketDto> getTicketsByScreeningId(@PathVariable int screeningId) {
        return ticketService.getTicketsByScreeningId(screeningId);
    }

    @GetMapping("/username/{username}")
    public List<TicketDto> getTicketByUsername(@PathVariable String username) {
        return ticketService.getTicketByUsername(username);
    }
}
