package ru.tilman.dao;

import ru.tilman.entity.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDAO {

    @PersistenceContext(name = "persistenceUnit")
    EntityManager em;

}
