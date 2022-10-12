package Backendkinoprojekt.repository;

import Backendkinoprojekt.entity.Bruger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Bruger, String> {
}
