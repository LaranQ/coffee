package com.vkhalec.shared;

import java.io.Serializable;

public class CoffeeDto implements Serializable {

    private Integer id;
    private String name;
    private Integer water;
    private Integer milk;
    private Integer beans;

    public CoffeeDto() {
    }

    public CoffeeDto(String id) {
        this.id = Integer.parseInt(id);
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

    @Override
    public String toString() {
        return  "</br>id=" + id +
                "</br>name='" + name +
                "</br>water=" + water +
                "</br>milk=" + milk +
                "</br>beans=" + beans;
    }
}
