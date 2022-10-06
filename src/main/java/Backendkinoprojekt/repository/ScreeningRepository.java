package Backendkinoprojekt.repository;


import Backendkinoprojekt.dto.ScreeningDto;
import Backendkinoprojekt.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
    List<Screening> findAllByScreeningStartTimeBetween(LocalDateTime start, LocalDateTime end);
}

