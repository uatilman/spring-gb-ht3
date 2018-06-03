package ru.tilman.dao;

import ru.tilman.entity.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDAO {

    @PersistenceContext(name = "persistenceUnit")
    EntityManager em;

    // TODO: 03.06.2018 НЕПРОВЕРЕННО
    public void removeById(String id, Class<? extends AbstractEntity> entityClass) {
        if (id == null || id.isEmpty()) return;
        AbstractEntity element = em.find(entityClass, id);
        em.remove(element);
    }

}
