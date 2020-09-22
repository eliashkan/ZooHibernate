package com.realdolmen.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Food")
@Table(name = "food", schema = "zooHibernate")
public class Food extends BaseEntity {
    private String foodName;

    @OneToMany(
            mappedBy = "food",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Animal> animals = new ArrayList<>();

    public String getFoodName() {
        return foodName;
    }

    public Food setFoodName(String foodName) {
        this.foodName = foodName;
        return this;
    }

     /*
         add and remove methods used to synchronize both sides of the bidirectional association.
         You should always provide these methods whenever you are working with a bidirectional association as,
         otherwise, you risk very subtle state propagation issues.
     */
    public void addFood(Animal animal) {
        animals.add(animal);
        animal.setFood(this);
    }

    public void removeFood(Animal animal) {
        animals.remove(animal);
        animal.setFood(null);
    }
}
