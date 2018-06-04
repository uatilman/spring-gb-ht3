package ru.tilman.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tilman.entity.AbstractEntity;
import ru.tilman.entity.Ad;

import java.util.List;


@Service
@Transactional
public class AdDAO extends AbstractDAO {

    public void persist(Ad ad) {
        if (ad == null) return;
        em.persist(ad);
    }

    public void merge(Ad ad) {
        if (ad == null) return;
        em.merge(ad);
    }

    public List<Ad> getAdList() {
        return em.createQuery("SELECT el FROM Ad el", Ad.class).getResultList();
    }

    public void  persistAdList(List<Ad> adList) {
        if (adList == null) return;

        for (Ad ad : adList) {
            if (ad == null) continue;
            em.persist(ad);
        }
    }

    // TODO: 03.06.2018 НЕПРОВЕРЕННО
    public void removeById(String id) {
        if (id == null || id.isEmpty()) return;
        Ad element = em.find(Ad.class, id);
        em.remove(element);
    }
}
