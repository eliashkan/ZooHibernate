package com.realdolmen.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Animal")
public class Animal extends BaseEntity {

    private String name;
    private Food food;

    @Column
    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    @Column
    public Food getFood() {
        return food;
    }

    public Animal setFood(Food food) {
        this.food = food;
        return this;
    }
}
