package Backendkinoprojekt.repository;

import Backendkinoprojekt.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
