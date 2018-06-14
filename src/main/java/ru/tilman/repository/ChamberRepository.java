package ru.tilman.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.tilman.entity.Chamber;

import java.util.List;

@Repository(value = "chamberRepository")
public interface ChamberRepository extends PagingAndSortingRepository<Chamber, Long> {
    List<Chamber> findByNameLikeOrderByIdAsc(String name);

    List<Chamber> findAllByOrderByIdAsc();

}
