package com.vkhalec.shared;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

//@ApiModel
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coffee")
public class Coffee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @ApiModelProperty
    Integer id;

    @Column(name = "name", length = 16, nullable = false)
//    @ApiModelProperty
    String name;

//    @ApiModelProperty(notes = "Минимальное количество воды для варки кофе.")
    @Column(name = "water", nullable = false)
    Integer water;

//    @ApiModelProperty(notes = "Минимальное количество молока для варки кофе.")
    @Column(name = "milk", nullable = false)
    Integer milk;

//    @ApiModelProperty(notes = "Минимальное количество бобов для варки кофе.")
    @Column(name = "beans", nullable = false)
    Integer beans;

    public Coffee(String id){
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
}