package com.vkhalec.coffee.shared;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

//@ApiModel
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Entity
@Table(name = "coffee_orders")
public class CoffeeOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
//    @ApiModelProperty
    Integer id;

//    @ApiModelProperty
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coffee")
    Coffee coffee;

//    @ApiModelProperty
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coffee_machine")
    CoffeeMachine coffeeMachine;

//    @ApiModelProperty
    @Column(name = "date", nullable = false, updatable = false, insertable = false)
    String date;

    public CoffeeOrder() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public CoffeeMachine getCoffeeMachine() {
        return coffeeMachine;
    }

    public void setCoffeeMachine(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}