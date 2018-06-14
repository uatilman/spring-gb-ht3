package ru.tilman.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "regions")
public class Regions {

    @Id
    @Column (name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private Districs districs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Districs getDistrics() {
        return districs;
    }

    public void setDistrics(Districs districs) {
        this.districs = districs;
    }
}
