package ru.tilman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tilman.dao.CompanyDAO;
import ru.tilman.entity.Company;

@Controller
@RequestMapping("/add")
public class CreateCompanyController {

    private final CompanyDAO companyDAO;

    @Autowired
    public CreateCompanyController(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    // ВОПРОС !!!!!!!!!!!!!!!!!!!
    // В методичке стр.14 в @RequestMapping есть параметр для params="form".
    // Что это? С ним ничего неработает.

    @RequestMapping(method = RequestMethod.GET)
    public String getForm(Model uiModel) {
        Company company = new Company();
        System.out.println(company);
        uiModel.addAttribute("company", company);
        return "add";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(Company company, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) companyDAO.persist(company);
        return "redirect:companies";
    }


}
