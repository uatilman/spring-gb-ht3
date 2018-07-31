package ru.tilman.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.tilman.entity.Indicator;

import java.util.List;

@Repository(value = "indicatorRepository")
public interface IndicatorRepository extends PagingAndSortingRepository<Indicator, Long> {
    List<Indicator> findAll();
}
