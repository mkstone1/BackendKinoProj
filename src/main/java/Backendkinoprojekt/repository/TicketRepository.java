package Backendkinoprojekt.repository;

import Backendkinoprojekt.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
