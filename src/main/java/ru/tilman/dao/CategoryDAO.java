package ru.tilman.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tilman.entity.Category;

import java.util.List;


@Service
@Transactional
public class CategoryDAO extends AbstractDAO {

    public void persist(Category category) {
        if (category == null) return;
        em.persist(category);
    }

    public void merge(Category category) {
        if (category == null) return;
        em.merge(category);
    }

    public void  persistCategoryList(List<Category> categoryList) {
        if (categoryList == null) return;

        for (Category category : categoryList) {
            if (category == null) continue;
            em.persist(category);
        }
    }

}
