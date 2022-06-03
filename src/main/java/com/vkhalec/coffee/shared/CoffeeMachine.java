package com.vkhalec.coffee.shared;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

//@ApiModel
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@Entity
@Table(name = "coffee_machine")
public class CoffeeMachine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;

//    @ApiModelProperty
    @Setter
    @Column(name = "name", nullable = false, length = 32)
    String name = "default_name";

//    @ApiModelProperty
    @Setter
    @Column(name = "water", nullable = false)
    Integer water = 0;

//    @ApiModelProperty
    @Setter
    @Column(name = "milk", nullable = false)
    Integer milk = 0;

//    @ApiModelProperty
    @Setter
    @Column(name = "beans", nullable = false)
    Integer beans = 0;

//    @ApiModelProperty(notes = "Количество кофе, которое можно приготовить до необходимости почистить кофемашину.")
    @Setter
    @Column(name = "count_before_dirty")
    Integer countBeforeDirty = 5;

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