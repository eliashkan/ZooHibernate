package com.realdolmen.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Food extends BaseEntity {
    private String foodName;

    @Column
    public String getFoodName() {
        return foodName;
    }

    public Food setFoodName(String foodName) {
        this.foodName = foodName;
        return this;
    }
}
