package ru.tilman.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.tilman.entity.Ad;

import java.util.List;


@Repository
@Transactional
public class AdDAO extends AbstractDAO {

    public Ad getAdById(String id) {
        if (id == null) return null;
        return em.find(Ad.class, id);
    }

    public List<Ad> getAdList() {
        return em.createQuery("SELECT el FROM Ad el", Ad.class).getResultList();
    }

    public void removeById(String id) {
        removeById(id, Ad.class);
    }

}
