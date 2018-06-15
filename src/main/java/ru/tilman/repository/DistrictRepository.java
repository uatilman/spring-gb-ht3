package ru.tilman.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.tilman.entity.Chamber;
import ru.tilman.entity.District;

import java.util.List;

@Repository(value = "districtRepository")
public interface DistrictRepository extends PagingAndSortingRepository<District, Long> {


}
