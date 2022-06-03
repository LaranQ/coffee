package com.vkhalec.shared;

import java.io.Serializable;

public class CoffeeOrderDto implements Serializable {

    private Integer id;

    private CoffeeDto coffee;

    private CoffeeMachineDto coffeeMachine;

    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CoffeeDto getCoffee() {
        return coffee;
    }

    public void setCoffee(CoffeeDto coffee) {
        this.coffee = coffee;
    }

    public CoffeeMachineDto getCoffeeMachine() {
        return coffeeMachine;
    }

    public void setCoffeeMachine(CoffeeMachineDto coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "</br>id=" + id +
                "</br>coffee='" + coffee +
                "</br>coffeeMachine=" + coffeeMachine +
                "</br>date=" + date;
    }
}
