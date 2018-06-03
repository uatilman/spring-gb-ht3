package ru.tilman.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Для компании: идентификатор, название компании, описание, адрес компании;
 */

@Entity
public class Company extends AbstractEntity {

    @NotNull private String name;

    @NotNull private String description;

    @NotNull private String address;

/*    @OneToMany(mappedBy = "company", fetch = EAGER)
    private List<Ad> adList;*/

    public Company() {
    }

    public Company(String name, String description, String address) {
        this.name = name;
        this.description = description;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name;
    }
}
