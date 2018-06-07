package ru.tilman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tilman.entity.Company;

@Repository(value = "companyRepository")
public interface CompanyRepository extends JpaRepository<Company, String> {
}
