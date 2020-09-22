package com.realdolmen.model;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {

    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    public int getId() {
        return id;
    }

    public BaseEntity setId(int id) {
        this.id = id;
        return this;
    }
}
