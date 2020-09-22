package com.realdolmen.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Animal")
@Table(name = "animal", schema = "zooHibernate")
public class Animal extends BaseEntity {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Food food;

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public Food getFood() {
        return food;
    }

    public Animal setFood(Food food) {
        this.food = food;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return getId() != null &&
                Objects.equals(getName(), animal.getName()) &&
                Objects.equals(getFood(), animal.getFood()) &&
                Objects.equals(getId(), animal.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFood(), getId());
    }
}
