package com.vkhalec.coffee.shared;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "coffee")
public class Coffee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;

    @Column(name = "name", length = 16, nullable = false)
    String name;

    @Column(name = "water", nullable = false)
    Integer water;

    @Column(name = "milk", nullable = false)
    Integer milk;

    @Column(name = "beans", nullable = false)
    Integer beans;

    public Coffee(String id){
        this.id = Integer.parseInt(id);
    }

    public Coffee() {

    }

    public Coffee(Integer id, String name, Integer water, Integer milk, Integer beans) {
        this.id = id;
        this.name = name;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWater() {
        return water;
    }

    public void setWater(Integer water) {
        this.water = water;
    }

    public Integer getMilk() {
        return milk;
    }

    public void setMilk(Integer milk) {
        this.milk = milk;
    }

    public Integer getBeans() {
        return beans;
    }

    public void setBeans(Integer beans) {
        this.beans = beans;
    }
}