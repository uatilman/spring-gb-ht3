import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import ru.tilman.config.AppConfig;
import ru.tilman.dao.AdDAO;
import ru.tilman.dao.CategoryDAO;
import ru.tilman.dao.CompanyDAO;
import ru.tilman.entity.Ad;
import ru.tilman.entity.Category;
import ru.tilman.entity.Company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestJPA {

    private CompanyDAO companyDAO;
    private CategoryDAO categoryDAO;
    private AdDAO adDAO;

    private List<Company> companyList;
    private List<Category> categoryList;
    private List<Ad> adList;

    @BeforeSuite
    public void init() {
        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        companyDAO = context.getBean(CompanyDAO.class);
        categoryDAO = context.getBean(CategoryDAO.class);
        adDAO = context.getBean(AdDAO.class);
    }

    @Test(priority = 10)
    @Ignore
    public void isDBTablesEmpty() {
        Assert.assertEquals(companyDAO.getCompanyList().size(), 0);
        Assert.assertEquals(categoryDAO.getCategoryList().size(), 0);
        Assert.assertEquals(adDAO.getAdList().size(), 0);
    }

    @Test(priority = 20)
    public void persistData() {

        companyList = new ArrayList<>(Arrays.asList(
                new Company("Mercedes-benz", "Official Mercedes Benz dealer", "Moscow"),
                new Company("Pik", "The largest realtor", "St. Petersburg"),
                new Company("Ozon", "We build a life that everyone will buy", "Moscow")
        ));

        categoryList = new ArrayList<>(Arrays.asList(
                new Category("Cars"),
                new Category("House"),
                new Category("Books"),
                new Category("Phones")
        ));

        adList = new ArrayList<>(Arrays.asList(
                new Ad("Lorem ipsum dolor.", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa, veritatis.", categoryList.get(0), companyList.get(0), "+7-999-111-55-33"),
                new Ad("Lorem ipsum dolor.", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa, veritatis.", categoryList.get(1), companyList.get(1), "+7-999-111-55-33"),
                new Ad("Lorem ipsum dolor.", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa, veritatis.", categoryList.get(1), companyList.get(2), "+7-999-111-55-33"),
                new Ad("Lorem ipsum dolor.", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa, veritatis.", categoryList.get(2), companyList.get(2), "+7-999-111-55-33")
        ));

        companyDAO.persistList(companyList);
        categoryDAO.persistList(categoryList);
        adDAO.persistList(adList);

    }

    @Test(priority = 30)
    @Ignore
    public void findDataById() {
        Assert.assertEquals(companyList.get(0), companyDAO.getCompanyById(companyList.get(0).getId()));
        Assert.assertEquals(categoryList.get(0), categoryDAO.getCategoryById(categoryList.get(0).getId()));
        Assert.assertEquals(adList.get(0), adDAO.getAdById(adList.get(0).getId()));
    }

    @Test(priority = 40)
    @Ignore
    public void mergeData() {

        Company company = companyList.get(0);
        company.setDescription(" It is test string for merge.");
        companyDAO.merge(company);
        Assert.assertEquals(company, companyDAO.getCompanyById(company.getId()));

        Category category = categoryList.get(0);
        category.setName(" It is test string for merge.");
        categoryDAO.merge(category);
        Assert.assertEquals(category, categoryDAO.getCategoryById(category.getId()));

        Ad ad = adList.get(0);
        ad.setName(" It is test string for merge.");
        adDAO.merge(ad);
        Assert.assertEquals(ad, adDAO.getAdById(ad.getId()));

    }

    @Test(priority = 50)
    @Ignore
    public void removeData() {

        for (Ad el : adList) {
            adDAO.removeById(el.getId());
        }

        for (Company el : companyList) {
            companyDAO.removeById(el.getId());
        }

        for (Category el : categoryList) {
            categoryDAO.removeById(el.getId());
        }

        Assert.assertEquals(companyDAO.getCompanyList().size(), 0);
        Assert.assertEquals(categoryDAO.getCategoryList().size(), 0);
        Assert.assertEquals(adDAO.getAdList().size(), 0);

    }

    @AfterSuite
    @Ignore
    public void addDataToNextTest() {
        persistData();
    }

}
