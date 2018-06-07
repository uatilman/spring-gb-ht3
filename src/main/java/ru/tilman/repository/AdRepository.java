package ru.tilman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tilman.entity.Ad;

@Repository(value = "adRepository")
public interface AdRepository extends JpaRepository<Ad, String> {
}
