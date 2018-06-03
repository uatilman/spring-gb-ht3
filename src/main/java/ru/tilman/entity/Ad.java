package ru.tilman.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Для объявления: идентификатор, категория, название, содержание, номер телефона.
 */

@Entity
public class Ad extends AbstractEntity {

    @NotNull private String name;

    @NotNull private String content;

    @ManyToOne
    @JoinColumn (name = "category_id")
    @NotNull private Category category;

    @ManyToOne
    @JoinColumn (name = "company_id")
    @NotNull private Company company;

    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")
    private String phoneNumber;

    public Ad() {
    }

    public Ad(String name, String content, Category category, Company company, @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$") String phoneNumber) {
        this.name = name;
        this.content = content;
        this.category = category;
        this.company = company;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ad{");
        sb.append("name='").append(name).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", category=").append(category);
        sb.append(", company=").append(company);
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
