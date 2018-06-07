package ru.tilman.repository;

import org.springframework.transaction.annotation.Transactional;

import ru.tilman.entity.AbstractEntity;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import java.util.List;

@Transactional
public abstract class AbstractDAO {

    @PersistenceContext(name = "persistenceUnit")
    EntityManager em;

    public void persist(AbstractEntity entity) {
        if (entity == null) return;
        em.persist(entity);
    }

    public void persistList(List<? extends AbstractEntity> entityList) {
        if (entityList == null) return;

        for (AbstractEntity entity : entityList) {
            if (entity == null) continue;
            persist(entity);
        }
    }

    public void merge(AbstractEntity entity) {
        if (entity == null) return;
        em.merge(entity);
    }

    public void removeById(String id, Class<? extends AbstractEntity> entityClass) {
        if (id == null || id.isEmpty()) return;
        em.remove(em.find(entityClass, id));
    }

}
