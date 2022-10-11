package Backendkinoprojekt.repository;


import Backendkinoprojekt.dto.ScreeningDto;
import Backendkinoprojekt.entity.Screening;
import Backendkinoprojekt.entity.Theater;
import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
    List<Screening> findAllByScreeningStartTimeBetween(LocalDateTime start, LocalDateTime end);

    List<Screening> findAllByTheater(Theater theater);
}

