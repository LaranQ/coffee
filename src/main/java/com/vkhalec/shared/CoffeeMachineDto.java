package com.vkhalec.shared;

import java.io.Serializable;

public class CoffeeMachineDto implements Serializable {

    private Integer id;

    private String name;

    private Integer water;

    private Integer milk;

    private Integer beans;

    private Integer countBeforeDirty;

    public CoffeeMachineDto(String id) {
        this.id = Integer.parseInt(id);
    }

    public CoffeeMachineDto() {
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

    @Override
    public String toString() {
        return "</br>id=" + id +
                "</br>name='" + name +
                "</br>water=" + water +
                "</br>milk=" + milk +
                "</br>beans=" + beans +
                "</br>countBeforeDirty=" + countBeforeDirty;
    }
}
