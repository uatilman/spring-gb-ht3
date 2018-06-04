package ru.tilman.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        if (!super.equals(o)) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) &&
                Objects.equals(description, company.description) &&
                Objects.equals(address, company.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name, description, address);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Company{");
        sb.append(super.toString());
        sb.append("name='").append(name).append('\'');
        sb.append("name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
