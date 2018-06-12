package ru.tilman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tilman.entity.Company;

import java.util.List;

@Repository(value = "companyRepository")
public interface CompanyRepository extends JpaRepository<Company, String> {
    List <Company> findByName(String name);
}
