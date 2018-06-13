package ru.tilman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tilman.entity.Chamber;

import java.util.List;

@Repository(value = "chamberRepository")
public interface ChamberRepository extends JpaRepository<Chamber, Long> {
    List<Chamber> findByNameOrderByIdAsc(String name);
    List<Chamber> findAllByOrderByIdAsc();

}
