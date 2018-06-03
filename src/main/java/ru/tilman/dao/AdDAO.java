package ru.tilman.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
