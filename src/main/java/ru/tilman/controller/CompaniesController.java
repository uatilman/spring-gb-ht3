package ru.tilman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tilman.dao.CompanyDAO;
import ru.tilman.repository.CompanyRepository;

@Controller
@RequestMapping("/companies")
public class CompaniesController {

    public final static String MESSAGE_ATTRIBUTE = "message";
    public final static String COMPANIES_ATTRIBUTE = "companies";

    private final CompanyRepository companyRepository;

    @Autowired
    public CompaniesController(
            @Qualifier("companyRepository") CompanyRepository companyRepository
    ) {
        this.companyRepository = companyRepository;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String viewBase(Model uiModel) {
        uiModel.addAttribute(MESSAGE_ATTRIBUTE, "Information about all companies");
        uiModel.addAttribute(COMPANIES_ATTRIBUTE, companyRepository.findAll());
        return "companies";
    }

    @RequestMapping(value = "/{companyName}", method = RequestMethod.GET)
    public String viewCompaniesList(Model uiModel, @PathVariable(value = "companyName") String name) {
        uiModel.addAttribute(MESSAGE_ATTRIBUTE, "Information about company " + name);
        uiModel.addAttribute(COMPANIES_ATTRIBUTE, companyRepository.findByName(name));

        return "companies";
    }

}
