package ru.tilman.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Для категории: идентификатор, название категории;
 */
@Entity
public class Category extends AbstractEntity {

    @NotNull private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
