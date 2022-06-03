package com.vkhalec.coffee.shared;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "coffee_machine")
public class CoffeeMachine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 32)
    private String name = "default_name";

    @Column(name = "water", nullable = false)
    private Integer water = 0;

    @Column(name = "milk", nullable = false)
    private Integer milk = 0;

    @Column(name = "beans", nullable = false)
    private Integer beans = 0;

    @Column(name = "count_before_dirty")
    private Integer countBeforeDirty = 5;

    public CoffeeMachine(String id){
        this.id = Integer.parseInt(id);
    }

    public CoffeeMachine() {

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

    public Integer getCountBeforeDirty() {
        return countBeforeDirty;
    }

    public void setCountBeforeDirty(Integer countBeforeDirty) {
        this.countBeforeDirty = countBeforeDirty;
    }
}