package ru.tilman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tilman.entity.Ad;
import ru.tilman.repository.AdRepository;
import ru.tilman.repository.CategoryRepository;
import ru.tilman.repository.CompanyRepository;

import java.util.List;

@Service
public class ApplicationService {

    private CompanyRepository companyRepository;
    private CategoryRepository categoryRepository;
    private AdRepository adRepository;

    @Autowired
    public ApplicationService(
            @Qualifier("companyRepository") CompanyRepository companyRepository,
            @Qualifier("categoryRepository") CategoryRepository categoryRepository,
            @Qualifier("adRepository") AdRepository adRepository
    ) {
        this.companyRepository = companyRepository;
        this.categoryRepository = categoryRepository;
        this.adRepository = adRepository;
    }

    @Transactional(readOnly = true)
    public void printAllEntity() {
        System.out.println(companyRepository.findAll());
        System.out.println(categoryRepository.findAll());
        System.out.println(adRepository.findAll());
    }

    @Transactional
    public void removeFirstAd() {
        List<Ad> adList = adRepository.findAll();
        System.out.println("Count Ad before remove: " + adList.size());
        adRepository.delete(adList.get(0));
        adList = adRepository.findAll();
        System.out.println("Count Ad after remove: " + adList.size());
    }


}
