package Backendkinoprojekt.repository;

import Backendkinoprojekt.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findAllByScreeningId(int id);

    List<Ticket> findALlByUserWithRolesUsername(String username);
}
