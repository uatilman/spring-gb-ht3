package ru.tilman;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.tilman.dao.AdDAO;
import ru.tilman.dao.CategoryDAO;
import ru.tilman.dao.CompanyDAO;
import ru.tilman.entity.Ad;
import ru.tilman.entity.Category;
import ru.tilman.entity.Company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class App {

    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        final CompanyDAO companyDAO = context.getBean(CompanyDAO.class);
        final CategoryDAO categoryDAO = context.getBean(CategoryDAO.class);
        final AdDAO adDAO = context.getBean(AdDAO.class);

        final List<Company> companyList = new ArrayList<>(Arrays.asList(
                new Company("Mercedes-benz", "Official Mercedes Benz dealer", "Moscow"),
                new Company("Pik", "The largest realtor", "St. Petersburg"),
                new Company("Ozon", "We build a life that everyone will buy", "Moscow")
        ));

        final List<Category> categoryList = new ArrayList<>(Arrays.asList(
                new Category("Cars"),
                new Category("House"),
                new Category("Books"),
                new Category("Phones")
        ));

        final List<Ad> adList = new ArrayList<>(Arrays.asList(
                new Ad("Lorem ipsum dolor.", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa, veritatis.", categoryList.get(0), companyList.get(0), "+7-999-111-55-33"),
                new Ad("Lorem ipsum dolor.", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa, veritatis.", categoryList.get(1), companyList.get(1), "+7-999-111-55-33"),
                new Ad("Lorem ipsum dolor.", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa, veritatis.", categoryList.get(1), companyList.get(2), "+7-999-111-55-33"),
                new Ad("Lorem ipsum dolor.", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa, veritatis.", categoryList.get(2), companyList.get(2), "+7-999-111-55-33")
        ));

        companyDAO.persistCompanyList(companyList);
        categoryDAO.persistCategoryList(categoryList);
        adDAO.persistAdList(adList);

        System.out.println(companyDAO.getCompanyList());
        System.out.println(adDAO.getAdList());

        // TODO: 03.06.2018 remove, merge create, test all
        // TODO: тесты аналогично javaee book with script

    }

}
