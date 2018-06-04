package ru.tilman.dao;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import ru.tilman.entity.Company;

import java.util.List;


@Service
@Transactional
public class CompanyDAO extends AbstractDAO {

    public Company getCompanyById(String id) {
        if (id == null) return null;
        return em.find(Company.class, id);
    }

    public List<Company> getCompanyList() {
        return em.createQuery("SELECT el FROM Company el", Company.class).getResultList();
    }

    public void removeById(String id) {
        removeById(id, Company.class);
    }

}
