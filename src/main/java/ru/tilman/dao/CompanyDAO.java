package ru.tilman.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tilman.entity.Company;

import java.util.List;


@Service
@Transactional
public class CompanyDAO extends AbstractDAO {

    public void persist(Company company) {
        if (company == null) return;
        em.persist(company);
    }

    public void merge(Company company) {
        if (company == null) return;
        em.merge(company);
    }

    public List<Company> getCompanyList() {
        return em.createQuery("SELECT el FROM Company el", Company.class).getResultList();
    }

    public void persistCompanyList(List<Company> companyList) {
        if (companyList == null) return;

        for (Company company : companyList) {
            if (company == null) continue;
            em.persist(company);
        }

    }

}
