package Backendkinoprojekt.repository;

import Backendkinoprojekt.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer>
{
    Theater getTheatersById(int id);

}
