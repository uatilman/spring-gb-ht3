package ru.tilman.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.tilman.entity.Chamber;
import ru.tilman.entity.Region;

import java.util.List;

@Repository(value = "regionRepository")
public interface RegionRepository extends PagingAndSortingRepository<Region, Long> {


}
