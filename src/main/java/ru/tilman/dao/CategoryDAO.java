package ru.tilman.dao;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import ru.tilman.entity.Category;

import java.util.List;


@Service
@Transactional
public class CategoryDAO extends AbstractDAO {

    public Category getCategoryById(String id) {
        if (id == null) return null;
        return em.find(Category.class, id);
    }

    public List<Category> getCategoryList() {
        return em.createQuery("SELECT el FROM Category el", Category.class).getResultList();
    }

    public void removeById(String id) {
        removeById(id, Category.class);
    }

}
